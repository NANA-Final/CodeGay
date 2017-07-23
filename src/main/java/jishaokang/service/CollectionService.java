package jishaokang.service;

import jishaokang.model.Collection;
import jishaokang.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 收藏操作逻辑接口
 */
public interface CollectionService {

    //更换收藏状态
    Map changeCollection(Collection collection);

}