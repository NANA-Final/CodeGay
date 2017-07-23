package jishaokang.service;

import jishaokang.model.Code;
import jishaokang.model.Message;

import java.util.Map;

/**
 * 消息操作逻辑接口
 */
public interface MessageService {

    //发送消息
    Map newMessage(Message message);

    //按照用户获取消息
    Map getMessageByHostId(int hostId);

    //按照好友获取消息
    Map getMessageByFriendingId(int friendingId);

    //按照好友获取新消息
    Map getNewMessageByFriendingId(int friendingId);

}