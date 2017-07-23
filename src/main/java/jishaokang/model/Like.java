package jishaokang.model;

import lombok.Data;

/**
 * 点赞类
 */
@Data
public class Like {

    /*点赞ID*/
    private Integer likeId;
    /*点赞者*/
    private Integer userId;
    /*点赞文章*/
    private Integer articleId;
    /*点赞时间*/
    private String likeTime;

}
