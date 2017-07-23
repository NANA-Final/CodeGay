package jishaokang.dao;

import jishaokang.model.Friend;
import jishaokang.model.FriendRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对好友表的操作
 */
@Repository
public interface FriendDao {

    //新建好友
    void insert(Friend friend);

    //删除好友
    void delete(Friend friend);

    //修改备注姓名
    void updateFriendName(Friend friend);

    //更新信息阅读标记
    void updateMessageRead(Friend friend);

    //获取好友详情
    Friend selectByFriendingId(int friendingId);

    //获取用户的所有好友
    List<Friend> selectByHostId(int hostId);

}