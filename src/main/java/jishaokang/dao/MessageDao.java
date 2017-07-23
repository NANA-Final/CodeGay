package jishaokang.dao;

import jishaokang.model.Friend;
import jishaokang.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ‘对消息表的操作
 */
@Repository
public interface MessageDao {

    //插入消息
    void insert(Message message);

    //获取用户的所有消息
    List<Message> select(int hostId);

    //按照朋友获取消系
    List<Message> selectByFriend(Friend friend);

    //按照朋友获取未读消息
    List<Message> selectNewByFriend(Friend friend);

}