package jishaokang.model;

import lombok.Data;

/**
 * 用户类
 */
@Data
public class User {

    /*用户ID*/
    private Integer userId;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*头像*/
    private String headimg;
    /*总关注人数*/
    private Integer totalFollow;
    /*总被关注人数*/
    private Integer totalFollower;

}
