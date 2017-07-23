package jishaokang.service.impl;

import jishaokang.dao.ArticleDao;
import jishaokang.dao.CollectionDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Article;
import jishaokang.model.Collection;
import jishaokang.model.User;
import jishaokang.service.CollectionService;
import jishaokang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 文章操作逻辑接口
 */
@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionDao collectionDao;

    @Autowired
    ArticleDao articleDao;

    //切换收藏状态
    @Override
    public Map changeCollection(Collection collection) {
        Collection realcollection = collectionDao.select(collection);
        Map map = new HashMap();
        if (realcollection == null){
            collectionDao.insert(collection);
            articleDao.incCollection(collection.getArticleId());
            map.put("message","successfully collect");
        }else{
            collectionDao.delete(realcollection.getCollectionId());
            articleDao.decCollection(collection.getArticleId());
            map.put("message","delete collect");
        }
        return map;
    }

}