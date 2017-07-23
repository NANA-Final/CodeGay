package jishaokang.controller;

import jishaokang.model.Friend;
import jishaokang.model.FriendRequest;
import jishaokang.service.FriendRequestService;
import jishaokang.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 好友请求控制
 */
@RestController
@RequestMapping(value = "/back_end/friend")
public class FriendController {

    @Autowired
    FriendService friendService;

    //添加好友
    @RequestMapping(value = "/new_friend",method = RequestMethod.POST)
    public Map newFriend(Friend friend)
    {
        return friendService.newFriend(friend);
    }

    //更新好友信息
    @RequestMapping(value = "/update_friend",method = RequestMethod.POST)
    public Map updateFriend(Friend friend)
    {
        return friendService.updateFriend(friend);
    }

    //删除好友
    @RequestMapping(value = "/delete_friend",method = RequestMethod.POST)
    public Map deleteFriend(Friend friend)
    {
        return friendService.deleteFriend(friend);
    }

    //获取好友详情
    @RequestMapping(value = "/get_friend_detail",method = RequestMethod.POST)
    public Map getFriendDetail(int friendingId)
    {
        return friendService.getFriendDetail(friendingId);
    }

    //获取所有好友
    @RequestMapping(value = "/get_friend_by_hostId",method = RequestMethod.POST)
    public Map getFriendByHostId(int hostId)
    {
        return friendService.getFriendByHostId(hostId);
    }

}