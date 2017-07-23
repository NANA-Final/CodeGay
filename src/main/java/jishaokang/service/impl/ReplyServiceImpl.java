package jishaokang.service.impl;

import jishaokang.dao.DiscussDao;
import jishaokang.dao.NoticeDao;
import jishaokang.dao.ReplyDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Discuss;
import jishaokang.model.Notice;
import jishaokang.model.Reply;
import jishaokang.model.User;
import jishaokang.service.DiscussService;
import jishaokang.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 回复操作逻辑
 */
@Service("replyServiceImpl")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    DiscussDao discussDao;

    @Autowired
    ReplyDao replyDao;

    @Autowired
    UserDao userDao;

    @Autowired
    NoticeDao noticeDao;

    //新建回复
    @Override
    public Map newReply(Reply reply) {
        replyDao.insert(reply);
        Discuss discuss=discussDao.selectByDiscussId(reply.getDiscussId());
        discuss.setLatestReply(reply.getReplyId());
        discussDao.updateLatestReply(discuss);
        discussDao.incTotalReply(reply.getDiscussId());
        Notice notice = new Notice();
        notice.setContent("参与讨论:"+discuss.getTitle());
        notice.setNoticeTime(reply.getReplyTime());
        notice.setNoticerId(reply.getReplyerId());
        notice.setNoticeUrl("http://localhost:8081/discuss/discuss_detail?discussId="+discuss.getDiscusserId());
        noticeDao.insert(notice);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除回复
    @Override
    public Map deleteReply(int replyId) {
        Reply reply = replyDao.selectByReplyId(replyId);
        discussDao.decTotalReply(reply.getDiscussId());
        replyDao.delete(replyId);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取回复详情
    @Override
    public Map getReplyByReplyId(int replyId) {
        Reply reply = replyDao.selectByReplyId(replyId);
        Map map = new HashMap();
        if (reply == null){
            map.put("message","未查询到回复");
        }else{
            map.put("message","查询回复完毕");
            map.put("replies",reply);
        }
        return map;
    }

    //按讨论获取回复
    @Override
    public Map getReplyByDiscussId(int discussId) {
        List<Reply> replies = replyDao.selectByDiscussId(discussId);
        List<User> replyers = new ArrayList<User>();
        for (Reply reply:replies){
            replyers.add(userDao.selectByUserId(reply.getReplyerId()));
        }
        Map map = new HashMap();
        if (replies == null){
            map.put("message","未查询到回复");
        }else{
            map.put("message","查询回复完毕");
            map.put("replies",replies);
            map.put("replyers",replyers);
        }
        return map;
    }

    //获取用户的回复
    @Override
    public Map getReplyByUserId(int userId) {
        Discuss discuss;
        List<Reply> replies = replyDao.selectByUserId(userId);
        List<Discuss> discusses = new ArrayList<Discuss>();
        List<User> discussers = new ArrayList<User>();
        List<User> replyers = new ArrayList<User>();
        for (Reply reply:replies){
            discuss = discussDao.selectByDiscussId(reply.getDiscussId());
            discusses.add(discuss);
            discussers.add(userDao.selectByUserId(discuss.getDiscusserId()));
            replyers.add(userDao.selectByUserId(reply.getReplyerId()));
        }
        Map map = new HashMap();
        if (discusses == null){
            map.put("message","未查询到该用户回复的讨论");
        }else{
            map.put("message","查询该用户回复的讨论完毕");
            map.put("discusses",discusses);
            map.put("replies",replies);
            map.put("discussers",discussers);
            map.put("replyers",replyers);
        }
        return map;
    }

}