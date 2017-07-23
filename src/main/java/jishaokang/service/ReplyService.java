package jishaokang.service;

import jishaokang.model.Discuss;
import jishaokang.model.Reply;

import java.util.Map;

/**
 * 回复操作逻辑接口
 */
public interface ReplyService {

    //新建回复
    Map newReply(Reply reply);

    //删除回复
    Map deleteReply(int replyId);

    //获取回复详情
    Map getReplyByReplyId(int replyId);

    //按照讨论获取回复
    Map getReplyByDiscussId(int discussId);

    //获取用户的所有回复
    Map getReplyByUserId(int userId);

}