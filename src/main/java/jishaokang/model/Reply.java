package jishaokang.model;

import lombok.Data;

/**
 * 回复类
 */

@Data
public class Reply {

    /*回复ID*/
    private Integer replyId;
    /*所属讨论*/
    private Integer discussId;
    /*回复者*/
    private Integer replyerId;
    /*回复内容*/
    private String content;
    /*回复时间*/
    private String replyTime;

}
