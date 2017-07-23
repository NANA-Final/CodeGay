package jishaokang.service.impl;

import jishaokang.dao.ArticleDao;
import jishaokang.dao.LikeDao;
import jishaokang.dao.NoticeDao;
import jishaokang.model.Like;
import jishaokang.model.Notice;
import jishaokang.service.LikeService;
import jishaokang.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公告操作逻辑
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDao noticeDao;

    //获取公告
    @Override
    public Map getNoticeByNoticerId(int noticerId) {
        List<Notice> notices = noticeDao.selectByNoticerId(noticerId);
        Map map = new HashMap();
        if (notices == null){
            map.put("message","未查询到消息");
        }else{
            map.put("message","查询消息完毕");
            map.put("data",notices);
        }
        return map;
    }

}