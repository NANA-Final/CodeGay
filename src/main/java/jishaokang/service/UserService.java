package jishaokang.service;

import jishaokang.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户操作逻辑接口
 */
public interface UserService {

    //登录
    Map login(User user,HttpSession session);

    //注销
    Map unlogin(HttpSession session);

    //注册
    Map register(User user);

    //更改用户信息
    Map changeUserInformation(User user);

    //检查用户名
    Map checkUsername(String username);

    //获取已登录用户信息
    Map getUserInformation(HttpSession session);

    //按照ID获取用户
    Map getUserInformationByUserId(int userId);

    //按照用户名获取用户
    Map getUserInformationByUsername(String username);

    //更新
    Map update(User user);

}