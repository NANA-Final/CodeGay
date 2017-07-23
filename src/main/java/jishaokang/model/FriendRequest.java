package jishaokang.model;

import lombok.Data;

/**
 * 好友申请类
 */
@Data
public class FriendRequest{

    /*好友请求ID*/
    private Integer friendRequestId;
    /*发送者*/
    private Integer senderId;
    /*接收者*/
    private Integer receiverId;
    /*验证消息*/
    private String introduce;
    /*发送好友请求时间*/
    private String friendRequestTime;

}
