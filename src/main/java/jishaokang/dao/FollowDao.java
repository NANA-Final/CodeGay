package jishaokang.dao;

import jishaokang.model.Follow;
import jishaokang.model.Like;
import org.springframework.stereotype.Repository;

/**
 * 度关注表的操作
 */
@Repository
public interface FollowDao {

    //新建关注
    int insert(Follow follow);

    //删除关注
    int delete(Follow follow);

    //获取关注详情
    Follow select(Follow follow);

}