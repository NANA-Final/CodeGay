package jishaokang.service;

import jishaokang.model.Code;
import jishaokang.model.Discuss;

import java.util.Map;

/**
 * 讨论操作逻辑接口
 */
public interface DiscussService {

    //新建讨论
    Map newDiscuss(Discuss discuss);

    //删除讨论
    Map deleteDiscuss(int discussId);

    //获取所有讨论
    Map getDiscuss();

    //获取讨论详情
    Map getDiscussByDiscussId(int discussId);

    //获取用户的所有讨论
    Map getDiscussByUserId(int userId);

}