package jishaokang.model;

import lombok.Data;

/**
 * 消息类
 */
@Data
public class Message {

    /*消息ＩＤ*/
    private Integer messageId;
    /*发送者*/
    private Integer senderId;
    /*接收者*/
    private Integer receiverId;
    /*消息内容*/
    private String content;
    /*发送消息时间*/
    private String messageTime;

}
