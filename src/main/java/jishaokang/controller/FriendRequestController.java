package jishaokang.controller;

import jishaokang.model.Code;
import jishaokang.model.FriendRequest;
import jishaokang.service.CodeService;
import jishaokang.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 申请好友请求控制
 */
@RestController
@RequestMapping(value = "/back_end/friendRequest")
public class FriendRequestController {

    @Autowired
    FriendRequestService friendRequestService;

    //发送好友请求
    @RequestMapping(value = "/new_friendRequest",method = RequestMethod.POST)
    public Map newFriendRequest(FriendRequest friendRequest)
    {
        return friendRequestService.newFriendRequest(friendRequest);
    }

    //更新好友请求
    @RequestMapping(value = "/update_friendRequest",method = RequestMethod.POST)
    public Map updateFriendRequest(FriendRequest friendRequest)
    {
        return friendRequestService.updateFriendRequest(friendRequest);
    }

    //删除好友请求
    @RequestMapping(value = "/delete_friendRequest",method = RequestMethod.POST)
    public Map deleteFriendRequest(int friendRequestId)
    {
        return friendRequestService.deleteFriendRequest(friendRequestId);
    }

    //获取好友请求详情
    @RequestMapping(value = "/get_friendRequest_detail",method = RequestMethod.POST)
    public Map getFriendRequestDetail(int friendRequestId)
    {
        return friendRequestService.getFriendRequestDetail(friendRequestId);
    }

    //获取用户的好友请求
    @RequestMapping(value = "/get_friendRequest_by_receiverId",method = RequestMethod.POST)
    public Map getFriendRequestByReceiverId(int receiverId)
    {
        return friendRequestService.getFriendRequestByReceiverId(receiverId);
    }

}