package jishaokang.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户视图控制
 */
@Controller
@RequestMapping(value = "/user")
public class UserPageController {

    //登录视图
    @RequestMapping(value = "/login")
    public String login()
    {
        return "user/login";
    }

    //注册视图
    @RequestMapping(value = "/register")
    public String register()
    {
        return "user/register";
    }

    //主页视图
    @RequestMapping(value = "")
    public String homepage()
    {
        return "user/homepage";
    }

    //获取用户视图
    @RequestMapping(value = "/get_user")
    public String getUser()
    {
        return "user/get_user";
    }

    //设置视图
    @RequestMapping(value = "/setting")
    public String setting()
    {
        return "user/setting";
    }
}