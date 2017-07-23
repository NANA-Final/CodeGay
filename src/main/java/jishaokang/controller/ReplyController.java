package jishaokang.controller;

import jishaokang.model.Discuss;
import jishaokang.model.Reply;
import jishaokang.service.DiscussService;
import jishaokang.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 回复请求控制
 */
@RestController
@RequestMapping(value = "/back_end/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    //新建回复
    @RequestMapping(value = "/new_reply",method = RequestMethod.POST)
    public Map newReply(Reply reply)
    {
        return replyService.newReply(reply);
    }

    //删除回复
    @RequestMapping(value = "/delete_reply",method = RequestMethod.POST)
    public Map deleteReply(int replyId)
    {
        return replyService.deleteReply(replyId);
    }

    //按照讨论获取回复
    @RequestMapping(value = "/get_reply_by_discussId",method = RequestMethod.POST)
    public Map getReplyByDiscussId(int discussId)
    {
        return replyService.getReplyByDiscussId(discussId);
    }

    //按照用户获取回复
    @RequestMapping(value = "/get_reply_by_userId",method = RequestMethod.POST)
    public Map getReplyByUserId(int userId)
    {
        return replyService.getReplyByUserId(userId);
    }

}