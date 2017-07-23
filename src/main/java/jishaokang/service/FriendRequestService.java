package jishaokang.service;

import jishaokang.model.Code;
import jishaokang.model.FriendRequest;

import java.util.Map;

/**
 * 好友请求操作逻辑接口
 */
public interface FriendRequestService {

    //新建好友请求
    Map newFriendRequest(FriendRequest friendRequest);

    //更新好友请求
    Map updateFriendRequest(FriendRequest friendRequest);

    //获取好友请求
    Map deleteFriendRequest(int friendRequestId);

    //获取好友请求详情
    Map getFriendRequestDetail(int friendRequestId);

    //获取用户所有好友请求
    Map getFriendRequestByReceiverId(int receiverId);

}