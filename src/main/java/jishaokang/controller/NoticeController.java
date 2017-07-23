package jishaokang.controller;

import jishaokang.model.Like;
import jishaokang.service.LikeService;
import jishaokang.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 公告请求控制
 */
@RestController
@RequestMapping(value = "/back_end/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    //获取公告
    @RequestMapping(value = "/get_notice_by_noticerId",method = RequestMethod.POST)
    public Map getNoticeByNoticerId(int noticerId)
    {
        return noticeService.getNoticeByNoticerId(noticerId);
    }


}