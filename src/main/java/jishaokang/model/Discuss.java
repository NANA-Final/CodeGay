package jishaokang.model;

import lombok.Data;

/**
 * 讨论类
 */
@Data
public class Discuss {

    /*讨论ID*/
    private Integer discussId;
    /*讨论发起者*/
    private Integer discusserId;
    /*讨论标题*/
    private String title;
    /*讨论描述*/
    private String content;
    /*发起讨论时间*/
    private String discussTime;
    /*最新回复*/
    private Integer latestReply;
    /*总回复数*/
    private Integer totalReply;

}
