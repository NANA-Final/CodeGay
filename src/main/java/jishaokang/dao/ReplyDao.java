package jishaokang.dao;

import jishaokang.model.Follow;
import jishaokang.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对回复表的操作
 */
@Repository
public interface ReplyDao {

    //插入回复
    void insert(Reply reply);

    //删除回复
    void delete(int replyId);

    //获取回复详情
    Reply selectByReplyId(int replyId);

    //按照讨论获取回复
    List<Reply> selectByDiscussId(int discussId);

    //获取用户的回复
    List<Reply> selectByUserId(int userId);

}