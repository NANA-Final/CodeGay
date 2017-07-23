package jishaokang.controller;

import jishaokang.model.Follow;
import jishaokang.model.Like;
import jishaokang.service.FollowService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 关注请求控制
 */
@RestController
@RequestMapping(value = "/back_end/follow")
public class FollowController {

    @Autowired
    FollowService followService;

    //查看是否关注
    @RequestMapping(value = "/is_follow",method = RequestMethod.POST)
    public Map isFollow(Follow follow)
    {
        return followService.isFollow(follow);
    }

    //关注用户
    @RequestMapping(value = "/follow_user",method = RequestMethod.POST)
    public Map followUser(Follow follow)
    {
        return followService.followUser(follow);
    }

    //取消关注用户
    @RequestMapping(value = "/delete_follow_user",method = RequestMethod.POST)
    public Map deleteFollowUser(Follow follow)
    {
        return followService.deleteFollowUser(follow);
    }

}