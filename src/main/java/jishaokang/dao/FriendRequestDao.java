package jishaokang.dao;

import jishaokang.model.Code;
import jishaokang.model.FriendRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对好友请求表的操作
 */
@Repository
public interface FriendRequestDao {

    //新建好友请求
    void insert(FriendRequest friendRequest);

    //删除好友请求
    void delete(int friendRequestId);

    //更新好友请求
    void update(FriendRequest friendRequest);

    //查看所有好友请求
    FriendRequest selectByFriendRequestId(int friendRequestId);

    //获取好友请求详情
    List<FriendRequest> selectByReceiverId(int receiverId);

}