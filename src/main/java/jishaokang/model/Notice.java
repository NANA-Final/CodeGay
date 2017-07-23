package jishaokang.model;

import lombok.Data;

/**
 * 公告类
 */
@Data
public class Notice {

    /*公告ID*/
    private Integer noticeId;
    /*公告者*/
    private Integer noticerId;
    /*公告内容*/
    private String content;
    /*公告时间*/
    private String noticeTime;
    /*公告URL*/
    private String noticeUrl;

}
