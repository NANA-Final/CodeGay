package jishaokang.model;

import lombok.Data;

/**
 * 文章类
 */
@Data
public class Article {

    /*文章ID*/
    private Integer articleId;
    /*文章标题*/
    private String title;
    /*标签*/
    private String label;
    /*时间标签*/
    private String timeLabel;
    /*新建文章时间*/
    private String detailedTime;
    /*文章内容*/
    private String content;
    /*文章作者*/
    private String author;
    /*作者ID*/
    private Integer authorId;
    /*文章配图*/
    private String picture;
    /*总点赞数*/
    private Integer totalLike;
    /*总收藏数*/
    private Integer totalCollect;

}