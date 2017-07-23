package jishaokang.dao;

import jishaokang.model.Code;
import jishaokang.model.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对公告表的操作
 */
@Repository
public interface NoticeDao {

    //插入公告
    void insert(Notice notice);

    //获取用户的公告
    List<Notice> selectByNoticerId(int notiverId);

}