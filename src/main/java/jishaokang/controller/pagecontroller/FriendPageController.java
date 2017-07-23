package jishaokang.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 好友视图控制
 */
@Controller
@RequestMapping(value = "/friend")
public class FriendPageController {

    //好友主页视图
    @RequestMapping(value = "")
    public String homgpage()
    {
        return "friend/homepage";
    }

    //编辑好友视图
    @RequestMapping(value = "/edit_friend")
    public String ediFriend()
    {
        return "friend/edit_friend";
    }

    //联系详情视图
    @RequestMapping(value = "/contact_detail")
    public String contactDetail()
    {
        return "friend/contact_detail";
    }

    //聊天记录视图
    @RequestMapping(value = "/contact_history")
    public String contactHisory()
    {
        return "friend/contact_history";
    }

}