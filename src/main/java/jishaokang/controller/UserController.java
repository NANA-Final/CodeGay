package jishaokang.controller;

import jishaokang.model.User;
import jishaokang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户请求控制
 */
@RestController
@RequestMapping(value = "/back_end/user")
public class UserController{

    @Autowired
    UserService userService;

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(User user,HttpSession session)
    {
        return userService.login(user,session);
    }

    //注销
    @RequestMapping(value = "/unlogin",method = RequestMethod.POST)
    public Map unlogin(HttpSession session)
    {
        return userService.unlogin(session);
    }

    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map register(User user)
    {
        return userService.register(user);
    }

    //更新用户信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(User user)
    {
        return userService.update(user);
    }

    //获取已登录用户信息
    @RequestMapping(value = "/get_user_information",method = RequestMethod.POST)
    public Map getUserInformation(HttpSession session)
    {
        return userService.getUserInformation(session);
    }

    //按ID查找用户
    @RequestMapping(value = "/get_user_information_by_userId",method = RequestMethod.POST)
    public Map getUserInformationById(int userId)
    {
        return userService.getUserInformationByUserId(userId);
    }

    //按用户名查找用户
    @RequestMapping(value = "/get_user_information_by_username",method = RequestMethod.POST)
    public Map getUserInformationByUsername(String username)
    {
        return userService.getUserInformationByUsername(username);
    }

    //改变用户信息
    @RequestMapping(value = "/change_user_information",method = RequestMethod.POST)
    public Map changeUserInformation(User user)
    {
        return userService.changeUserInformation(user);
    }

    //检查用户名
    @RequestMapping(value = "/check_username",method = RequestMethod.POST)
    public Map checkUsername(String username)
    {
        return userService.checkUsername(username);
    }

}