package jishaokang.service.impl;

import jishaokang.dao.ArticleDao;
import jishaokang.dao.CollectionDao;
import jishaokang.dao.LikeDao;
import jishaokang.model.Collection;
import jishaokang.model.Like;
import jishaokang.service.CollectionService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 点赞操作逻辑
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;

    @Autowired
    ArticleDao articleDao;

    //更改点赞状态
    @Override
    public Map changeLike(Like like) {
        Like realLike = likeDao.select(like);
        Map map = new HashMap();
        if (realLike == null){
            likeDao.insert(like);
            articleDao.incLike(like.getArticleId());
            map.put("message","successfully like");
        }else{
            likeDao.delete(realLike.getLikeId());
            articleDao.decLike(like.getArticleId());
            map.put("message","delete like");
        }
        return map;
    }

}