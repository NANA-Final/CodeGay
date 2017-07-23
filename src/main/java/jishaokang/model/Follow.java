package jishaokang.model;

import lombok.Data;

/**
 * 关注类
 */
@Data
public class Follow {

    /*关注ID*/
    private Integer followId;
    /*关注者ID*/
    private Integer userId;
    /*被关注者ID*/
    private Integer followerId;
    /*关注时间*/
    private String followTime;

}
