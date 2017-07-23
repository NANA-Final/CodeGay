package jishaokang.dao;

import jishaokang.model.User;
import org.springframework.stereotype.Repository;

/**
 * 对用户表的操作
 */
@Repository
public interface UserDao {

    //插入用户
    int insert(User user);

    //更新用户信息
    int update(User user);

    //获取用户信息
    User selectByUserId(int userId);

    //按照用户名查找用户
    User selectByUsername(String username);

    //关注数+1
    int incFollow(int userId);

    //被关注数+1
    int incFollower(int userId);

    //关注数-1
    int decFollow(int userId);

    //被关注数-1
    int decFollower(int userId);

}