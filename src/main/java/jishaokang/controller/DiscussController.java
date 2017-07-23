package jishaokang.controller;

import jishaokang.model.Discuss;
import jishaokang.model.Friend;
import jishaokang.service.DiscussService;
import jishaokang.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 讨论请求控制
 */
@RestController
@RequestMapping(value = "/back_end/discuss")
public class DiscussController {

    @Autowired
    DiscussService discussService;

    //新建讨论
    @RequestMapping(value = "/new_discuss",method = RequestMethod.POST)
    public Map newDiscuss(Discuss discuss)
    {
        return discussService.newDiscuss(discuss);
    }

    //删除讨论
    @RequestMapping(value = "/delete_discuss",method = RequestMethod.POST)
    public Map deleteDiscuss(int discussId)
    {
        return discussService.deleteDiscuss(discussId);
    }

    //获取所有讨论
    @RequestMapping(value = "/get_discuss",method = RequestMethod.POST)
    public Map getDiscuss()
    {
        return discussService.getDiscuss();
    }

    //获取讨论详情
    @RequestMapping(value = "/get_discuss_by_discussId",method = RequestMethod.POST)
    public Map getDiscussByDiscussId(int discussId)
    {
        return discussService.getDiscussByDiscussId(discussId);
    }

    //获取用户的讨论
    @RequestMapping(value = "/get_discuss_by_userId",method = RequestMethod.POST)
    public Map getDiscussByUserId(int userId)
    {
        return discussService.getDiscussByUserId(userId);
    }

}