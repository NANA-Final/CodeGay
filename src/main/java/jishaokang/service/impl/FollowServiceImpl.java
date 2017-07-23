package jishaokang.service.impl;

import jishaokang.dao.ArticleDao;
import jishaokang.dao.FollowDao;
import jishaokang.dao.LikeDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Follow;
import jishaokang.model.Like;
import jishaokang.service.FollowService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 关注操作逻辑
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {

    @Autowired
    FollowDao followDao;

    @Autowired
    UserDao userDao;

    //判断是否关注
    @Override
    public Map isFollow(Follow follow) {
        Follow realFollow = followDao.select(follow);
        Map map = new HashMap();
        if (realFollow == null){
            map.put("message","false");
        }else{
            map.put("message","true");
        }
        return map;
    }

    //关注用户
    @Override
    public Map followUser(Follow follow) {
        Map map = new HashMap();
        followDao.insert(follow);
        userDao.incFollow(follow.getFollowerId());
        userDao.incFollower(follow.getUserId());
        map.put("message","succeed follow");
        return map;
    }

    //取消关注
    @Override
    public Map deleteFollowUser(Follow follow) {
        Map map = new HashMap();
        followDao.delete(follow);
        userDao.decFollow(follow.getFollowerId());
        userDao.decFollower(follow.getUserId());
        map.put("message","succeed delete");
        return map;
    }

}