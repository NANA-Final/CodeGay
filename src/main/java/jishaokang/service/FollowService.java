package jishaokang.service;

import jishaokang.model.Follow;
import jishaokang.model.Like;

import java.util.Map;

/**
 * 关注操作逻辑接口
 */
public interface FollowService {

    //判断是否关注
    Map isFollow(Follow follow);

    //添加关注
    Map followUser(Follow follow);

    //取消关注
    Map deleteFollowUser(Follow follow);

}