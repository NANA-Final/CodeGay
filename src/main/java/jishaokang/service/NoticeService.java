package jishaokang.service;

import jishaokang.model.Like;

import java.util.Map;

/**
 * 公告操作逻辑接口
 */
public interface NoticeService {

    //获取公告
    Map getNoticeByNoticerId(int noticerId);

}