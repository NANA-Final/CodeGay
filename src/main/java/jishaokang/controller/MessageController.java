package jishaokang.controller;

import jishaokang.model.Friend;
import jishaokang.model.Message;
import jishaokang.service.FriendService;
import jishaokang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 消息请求控制
 */
@RestController
@RequestMapping(value = "/back_end/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    //发送消息
    @RequestMapping(value = "/new_message",method = RequestMethod.POST)
    public Map newMessage(Message message)
    {
        return messageService.newMessage(message);
    }

    //获取所有消息
    @RequestMapping(value = "/get_message_by_hostId",method = RequestMethod.POST)
    public Map getMessageByHostId(int hostId)
    {
        return messageService.getMessageByHostId(hostId);
    }

    //按照好友获取消息
    @RequestMapping(value = "/get_message_by_friendingId",method = RequestMethod.POST)
    public Map getMessageByFriendingId(int friendingId)
    {
        return messageService.getMessageByFriendingId(friendingId);
    }

    //按照好友获取新消息
    @RequestMapping(value = "/get_new_message_by_friendingId",method = RequestMethod.POST)
    public Map getNewMessageByFriendingId(int friendingId)
    {
        return messageService.getNewMessageByFriendingId(friendingId);
    }

}