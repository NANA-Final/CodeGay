package jishaokang.service.impl;

import jishaokang.dao.UserDao;
import jishaokang.model.User;
import jishaokang.service.UserService;
import jishaokang.util.Cryptographic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户操作逻辑
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    //登录
    @Override
    public Map login(User user,HttpSession session) {
        Map map = new HashMap();
        try {
            user.setPassword(Cryptographic.sha256(user.getUsername()+"{"+user.getPassword()+"}"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User realuser=userDao.selectByUsername(user.getUsername());
        if (realuser.getPassword().equals(user.getPassword()))
        {
            session.setAttribute("userId",realuser.getUserId());
            map.put("message","succeed");
        }
        else map.put("message","failed");
        return map;
    }

    //注销
    @Override
    public Map unlogin(HttpSession session) {
        Map map = new HashMap();
        session.setAttribute("userId",null);
        map.put("message","succeed");
        return map;
    }

    //注册
    @Override
    public Map register(User user){
        try {
            user.setPassword(Cryptographic.sha256(user.getUsername()+"{"+user.getPassword()+"}"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userDao.insert(user);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    //修改用户信息
    @Override
    public Map changeUserInformation(User user) {
        userDao.update(user);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    //检查用户名是否存在
    @Override
    public Map checkUsername(String username) {
        Map map = new HashMap();
        User realuser=userDao.selectByUsername(username);
        if (realuser!=null) map.put("message","用户存在");
        else map.put("message","用户不存在");
        return map;
    }

    //获取用户信息
    @Override
    public Map getUserInformation(HttpSession session) {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());
        User user=userDao.selectByUserId(userId);
        Map map = new HashMap();
        map.put("message","succeed");
        map.put("data",user);
        return map;
    }

    //获取用户详情
    @Override
    public Map getUserInformationByUserId(int uesrId) {
        User user=userDao.selectByUserId(uesrId);
        Map map = new HashMap();
        map.put("message","succeed");
        map.put("data",user);
        return map;
    }

    //按用户名查找用户
    @Override
    public Map getUserInformationByUsername(String username) {
        User user=userDao.selectByUsername(username);
        Map map = new HashMap();
        if (user!=null){
            map.put("message","succeed");
            map.put("data",user);
        }else{
            map.put("message","用户名不存在");
            map.put("data",user);
        }
        return map;
    }

    //更新用户
    @Override
    public Map update(User user) {
        try {
            user.setPassword(Cryptographic.sha256(user.getUsername()+"{"+user.getPassword()+"}"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        userDao.update(user);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

}