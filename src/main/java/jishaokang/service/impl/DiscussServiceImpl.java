package jishaokang.service.impl;

import jishaokang.dao.*;
import jishaokang.model.*;
import jishaokang.service.DiscussService;
import jishaokang.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 讨论操作逻辑
 */
@Service("discussServiceImpl")
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    DiscussDao discussDao;

    @Autowired
    ReplyDao replyDao;

    @Autowired
    UserDao userDao;

    @Autowired
    NoticeDao noticeDao;

    //新建讨论
    @Override
    public Map newDiscuss(Discuss discuss) {
        discussDao.insert(discuss);
        Notice notice = new Notice();
        notice.setContent("发起讨论:"+discuss.getTitle());
        notice.setNoticeTime(discuss.getDiscussTime());
        notice.setNoticerId(discuss.getDiscusserId());
        notice.setNoticeUrl("http://localhost:8081/discuss/discuss_detail?discussId="+discuss.getDiscusserId());
        noticeDao.insert(notice);
        Reply reply = new Reply();
        reply.setDiscussId(discuss.getDiscussId());
        reply.setContent(discuss.getContent());
        reply.setReplyTime(discuss.getDiscussTime());
        reply.setReplyerId(discuss.getDiscusserId());
        replyDao.insert(reply);
        discuss.setLatestReply(reply.getReplyId());
        discussDao.updateLatestReply(discuss);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除讨论
    @Override
    public Map deleteDiscuss(int discussId) {
        discussDao.delete(discussId);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取所有讨论
    @Override
    public Map getDiscuss() {
        Reply reply;
        List<Discuss> discusses = discussDao.select();
        List<Reply> replies = new ArrayList<Reply>();
        List<User> discussers = new ArrayList<User>();
        List<User> replyers = new ArrayList<User>();
        for (Discuss discuss : discusses){
            reply = replyDao.selectByReplyId(discuss.getLatestReply());
            replies.add(reply);
            discussers.add(userDao.selectByUserId(discuss.getDiscusserId()));
            replyers.add(userDao.selectByUserId(reply.getReplyerId()));
        }
        Map map = new HashMap();
        if (discusses == null){
            map.put("message","未查询到讨论");
        }else{
            map.put("message","查询讨论完毕");
            map.put("discusses",discusses);
            map.put("replies",replies);
            map.put("discussers",discussers);
            map.put("replyers",replyers);
        }
        return map;
    }

    //获取讨论详情
    @Override
    public Map getDiscussByDiscussId(int discussId) {
        Discuss discuss = discussDao.selectByDiscussId(discussId);
        User discusser = userDao.selectByUserId(discuss.getDiscusserId());
        Map map = new HashMap();
        if (discuss == null){
            map.put("message","未查询到讨论");
        }else{
            map.put("message","查询讨论完毕");
            map.put("discuss",discuss);
            map.put("discusser",discusser);
        }
        return map;
    }

    //获取用户的讨论
    @Override
    public Map getDiscussByUserId(int userId) {
        Reply reply;
        List<Discuss> discusses = discussDao.selectByUserId(userId);
        List<Reply> replies = new ArrayList<Reply>();
        List<User> discussers = new ArrayList<User>();
        List<User> replyers = new ArrayList<User>();
        for (Discuss discuss : discusses){
            reply = replyDao.selectByReplyId(discuss.getLatestReply());
            replies.add(reply);
            discussers.add(userDao.selectByUserId(discuss.getDiscusserId()));
            replyers.add(userDao.selectByUserId(reply.getReplyerId()));
        }
        Map map = new HashMap();
        if (discusses == null){
            map.put("message","未查询到该用户创建的讨论");
        }else{
            map.put("message","查询该用户创建的讨论完毕");
            map.put("discusses",discusses);
            map.put("replies",replies);
            map.put("discussers",discussers);
            map.put("replyers",replyers);
        }
        return map;
    }

}