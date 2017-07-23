package jishaokang.service.impl;

import jishaokang.dao.FriendDao;
import jishaokang.dao.FriendRequestDao;
import jishaokang.dao.MessageDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Friend;
import jishaokang.model.FriendRequest;
import jishaokang.model.User;
import jishaokang.service.FriendRequestService;
import jishaokang.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 好友操作逻辑
 */
@Service("friendService")
public class FriendServiceImpl implements FriendService {

    @Autowired
    FriendDao friendDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MessageDao messageDao;

    //添加好友
    @Override
    public Map newFriend(Friend friend) {
        friendDao.insert(friend);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //更新好友信息
    @Override
    public Map updateFriend(Friend friend) {
        friendDao.updateFriendName(friend);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除好友
    @Override
    public Map deleteFriend(Friend friend) {
        friendDao.delete(friend);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取好友详情
    @Override
    public Map getFriendDetail(int friendingId) {
        Friend friend = friendDao.selectByFriendingId(friendingId);
        Map map = new HashMap();
        if (friend == null){
            map.put("message","未查询到好友");
        }else{
            map.put("message","查询好友完毕");
            map.put("data",friend);
        }
        return map;
    }

    //获取用户所有好友
    @Override
    public Map getFriendByHostId(int hostId) {
        List<Friend> friends = friendDao.selectByHostId(hostId);
        List<User> users = new ArrayList<User>();
        List<Integer> messageNums = new ArrayList<Integer>();
        for (Friend friend :friends){
            users.add(userDao.selectByUserId(friend.getFriendId()));
            messageNums.add(messageDao.selectNewByFriend(friend).size());
        }
        Map map = new HashMap();
        if (friends == null){
            map.put("message","未查询到好友");
        }else{
            map.put("message","查询好友完毕");
            map.put("friend",friends);
            map.put("user",users);
            map.put("messageNum",messageNums);
        }
        return map;
    }

}