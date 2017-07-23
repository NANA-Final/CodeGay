package jishaokang.dao;

import jishaokang.model.Discuss;
import jishaokang.model.Follow;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对讨论表的操作
 */
@Repository
public interface DiscussDao {

    //新建讨论
    void insert(Discuss discuss);

    //删除讨论
    void delete(int discussId);

    //更新最新回复
    void updateLatestReply(Discuss discuss);

    //回复数+1
    void incTotalReply(int discussId);

    //回复数-1
    void decTotalReply(int discussId);

    //获取讨论
    List<Discuss> select();

    //获取讨论详情
    Discuss selectByDiscussId(int discussId);

    //获取特定用户建立的讨论
    List<Discuss> selectByUserId(int discusserId);

}