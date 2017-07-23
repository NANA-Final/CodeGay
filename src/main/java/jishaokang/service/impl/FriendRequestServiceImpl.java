package jishaokang.service.impl;

import jishaokang.dao.CodeDao;
import jishaokang.dao.FriendRequestDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Code;
import jishaokang.model.FriendRequest;
import jishaokang.model.User;
import jishaokang.service.CodeService;
import jishaokang.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 好友申请操作逻辑
 */
@Service("friendRequestService")
public class FriendRequestServiceImpl implements FriendRequestService {

    @Autowired
    FriendRequestDao friendRequestDao;

    @Autowired
    UserDao userDao;

    //新建好友申请
    @Override
    public Map newFriendRequest(FriendRequest friendRequest) {
        friendRequestDao.insert(friendRequest);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //更新好友申请
    @Override
    public Map updateFriendRequest(FriendRequest friendRequest) {
        friendRequestDao.update(friendRequest);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除好友申请
    @Override
    public Map deleteFriendRequest(int friendRequestId) {
        friendRequestDao.delete(friendRequestId);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取好友申请详情
    @Override
    public Map getFriendRequestDetail(int friendRequestId) {
        FriendRequest friendRequest = friendRequestDao.selectByFriendRequestId(friendRequestId);
        Map map = new HashMap();
        if (friendRequest == null){
            map.put("message","未查询到好友申请");
        }else{
            map.put("message","查询好友申请完毕");
            map.put("data",friendRequest);
        }
        return map;
    }

    //获取用户的好友申请
    @Override
    public Map getFriendRequestByReceiverId(int receiverId) {
        List<FriendRequest> friendRequests = friendRequestDao.selectByReceiverId(receiverId);
        List<User> users = new ArrayList<User>();
        for (FriendRequest friendRequest : friendRequests){
            users.add(userDao.selectByUserId(friendRequest.getSenderId()));
        }
        Map map = new HashMap();
        if (friendRequests == null){
            map.put("message","未查询到好友申请");
        }else{
            map.put("message","查询好友申请完毕");
            map.put("friendRequest",friendRequests);
            map.put("user",users);
        }
        return map;
    }

}