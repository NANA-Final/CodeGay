package jishaokang.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 讨论视图控制
 */
@Controller
@RequestMapping(value = "/discuss")
public class DiscussPageController {

    //讨论主页视图
    @RequestMapping(value = "")
    public String homgpage()
    {
        return "discuss/homepage";
    }

    //讨论详情视图
    @RequestMapping(value = "/discuss_detail")
    public String discussDetail()
    {
        return "discuss/discuss_detail";
    }

    //获取讨论视图
    @RequestMapping(value = "/get_discuss")
    public String getDiscuss()
    {
        return "discuss/get_discuss";
    }

}