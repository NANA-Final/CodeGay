package jishaokang.dao;

import jishaokang.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 对文章表的操作
 */
@Repository
public interface ArticleDao {

    //新建文章
    int insert(Article article);

    //编辑文章
    int update(Article article);

    //删除文章
    int delete(int articleId);

    //按照文章ID查找文章
    Article selectByArticleId(int articleId);

    //按照标题查找文章
    List<Article> selectByTitle(String title);

    //按照作者查找文章
    List<Article> selectByAuthorId(int authorId);

    //按照标题查找特定作者的文章
    List<Article> selectByAuthorIdAndTitle(Map requestMap);

    //按照标签查找特定作者的文章
    List<Article> selectByAuthorIdAndLabel(Map requestMap);

    //按照时间查找特定作者的文章
    List<Article> selectByAuthorIdAndTimeLabel(Map requestMap);

    //收藏数+1
    int incCollection(int articleId);

    //收藏数-1
    int decCollection(int articleId);

    //查找用户收藏的文章
    List<Article> selectCollectionByUserId(int userId);

    //点赞数+1
    int incLike(int articleId);

    //点赞数-1
    int decLike(int articleId);

    //查找用户点赞的文章
    List<Article> selectLikeByUserId(int userId);

    //获取最新文章
    List<Article> selectByTime();

    //按照点赞数排序获取文章
    List<Article> selectByLike();

    //获取用户关注作者的文章
    List<Article> selectFollowByUserId(int userId);

}