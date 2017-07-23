package jishaokang.service;

import jishaokang.model.Friend;
import jishaokang.model.FriendRequest;

import java.util.Map;

/**
 * 好友操作逻辑接口
 */
public interface FriendService {

    //添加好友
    Map newFriend(Friend friend);

    //更新好友信息
    Map updateFriend(Friend friend);

    //删除好友
    Map deleteFriend(Friend friend);

    //获取好友详情
    Map getFriendDetail(int friendingId);

    //获取用户的所有好友
    Map getFriendByHostId(int hostId);

}