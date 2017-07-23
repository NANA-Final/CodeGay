package jishaokang.dao;

import jishaokang.model.Collection;
import jishaokang.model.Like;
import org.springframework.stereotype.Repository;

/**
 * 对点赞表的操作
 */
@Repository
public interface LikeDao {

    //新建点赞
    int insert(Like like);

    //删除点赞
    int delete(int likeId);

    //获取点赞详情
    Like select(Like like);

}