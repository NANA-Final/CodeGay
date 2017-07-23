package jishaokang.model;

import lombok.Data;

/**
 * 收藏类
 */
@Data
public class Collection {

    /*收藏Id*/
    private Integer CollectionId;
    /*收藏者ID*/
    private Integer userId;
    /*收藏的文章ID*/
    private Integer articleId;
    /*收藏时间*/
    private String collectionTime;

}
