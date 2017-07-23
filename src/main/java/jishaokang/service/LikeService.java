package jishaokang.service;

import jishaokang.model.Collection;
import jishaokang.model.Like;

import java.util.Map;

/**
 * 点赞操作逻辑接口
 */
public interface LikeService {

    //更改点赞状态
    Map changeLike(Like like);

}