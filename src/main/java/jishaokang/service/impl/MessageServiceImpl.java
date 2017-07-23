package jishaokang.service.impl;

import jishaokang.dao.FriendDao;
import jishaokang.dao.MessageDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Friend;
import jishaokang.model.Message;
import jishaokang.model.User;
import jishaokang.service.FriendService;
import jishaokang.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 消息操作逻辑
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Autowired
    FriendDao friendDao;

    @Autowired
    UserDao userDao;

    //发送消息
    @Override
    public Map newMessage(Message message) {
        messageDao.insert(message);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取用户消息
    @Override
    public Map getMessageByHostId(int hostId) {
        List<Message> originMessages = messageDao.select(hostId);
        List<Message> messages = new ArrayList<Message>();
        List<User> users = new ArrayList<User>();
        int friendId;
        Set<Integer> friendIds = new HashSet<Integer>();
        for (Message message:originMessages){
            friendId = message.getSenderId()==hostId ? message.getReceiverId() : message.getSenderId();
            if (!(friendIds.contains(friendId))){
                messages.add(message);
                users.add(userDao.selectByUserId(friendId));
                friendIds.add(friendId);
            }
        }
        Map map = new HashMap();
        if (messages.isEmpty()){
            map.put("message","未查询到列表好友消息");
        }else{
            map.put("message","查询列表好友消息完毕");
            map.put("messages",messages);
            map.put("user",users);
        }
        return map;
    }

    //获取特定好友的消息
    @Override
    public Map getMessageByFriendingId(int friendingId) {
        Friend friend = friendDao.selectByFriendingId(friendingId);
        List<Message> messages = messageDao.selectByFriend(friend);
        List<User> users = new ArrayList<User>();
        for (Message message:messages){
            users.add(userDao.selectByUserId(message.getSenderId()));
        }
        Map map = new HashMap();
        if (messages.isEmpty()){
            map.put("message","未查询到消息");
        }else{
            map.put("message","查询消息完毕");
            map.put("messages",messages);
            map.put("user",users);
        }
        return map;
    }

    //获取特定好友的新消息
    @Override
    public Map getNewMessageByFriendingId(int friendingId) {
        Friend friend = friendDao.selectByFriendingId(friendingId);
        List<Message> messages = messageDao.selectNewByFriend(friend);
        List<User> users = new ArrayList<User>();
        for (Message message:messages){
            users.add(userDao.selectByUserId(message.getSenderId()));
        }
        Map map = new HashMap();
        if (messages.isEmpty()){
            map.put("message","未查询到新消息");
        }else{
            map.put("message","查询新消息完毕");
            map.put("messages",messages);
            map.put("user",users);
            friend.setMessageRead(messages.get(messages.size()-1).getMessageId());
            friendDao.updateMessageRead(friend);
        }
        return map;
    }

}