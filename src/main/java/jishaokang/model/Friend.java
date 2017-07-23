package jishaokang.model;

import lombok.Data;

/**
 * 好友类
 */
@Data
public class Friend {

    /*添加好友ID*/
    private Integer FriendingId;
    /*好友1ID*/
    private Integer hostId;
    /*好友2ID*/
    private Integer friendId;
    /*添加好友时间*/
    private String friendTime;
    /*好友备注姓名*/
    private String friendName;
    /*已阅读消息*/
    private Integer messageRead;

}
