package jishaokang.dao;

import jishaokang.model.Article;
import jishaokang.model.Collection;
import jishaokang.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 对收藏表的操作
 */
@Repository
public interface CollectionDao {

    //新建收藏
    int insert(Collection collection);

    //删除收藏
    int delete(int collectionId);

    //获取收藏详情
    Collection select(Collection collection);

}