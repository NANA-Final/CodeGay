package jishaokang.service;

import jishaokang.model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章操作逻辑接口
 */
public interface ArticleService {

    //新建文章
    Map newArticle(Article article);

    //编辑文章
    Map editArticle(Article article);

    //删除文章
    Map deleteArticle(int articleId);

    //获取文章详情
    Map getDetailedArticle(int articleId);

    //获取文章标签
    Map getLabel(int authorId);

    //获取文章时间标签
    Map getTimeLabel(int authorId);

    //按照作者获取文章
    Map getArticleByAuthorId(int authorId);

    //按照标题获取文章
    Map getArticleByTitle(String title);

    //按照作者标题获取文章
    Map getArticleByAuthorIdAndTitle(int authorId, String title);

    //按照作者标签获取文章
    Map getArticleByAuthorIdAndLabel(int authorId,String label);

    //按照作者时间标签获取文章
    Map getArticleByAuthorIdAndTimeLabel(int authorId,String timeLabel);

    //获取收藏的文章
    Map getCollection(int userId);

    //获取点赞的文章
    Map getLike(int userId);

    //获取最新文章
    Map getNewArticle();

    //获取最热文章
    Map getHotArticle();

    //获取关注文章
    Map getFollow(int userId);

}