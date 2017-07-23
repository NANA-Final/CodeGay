package jishaokang.controller;

import jishaokang.model.Article;
import jishaokang.model.Collection;
import jishaokang.model.Like;
import jishaokang.model.User;
import jishaokang.service.ArticleService;
import jishaokang.service.CollectionService;
import jishaokang.service.LikeService;
import jishaokang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文章请求控制
 */
@RestController
@RequestMapping(value = "/back_end/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    LikeService likeService;

    //新建文章
    @RequestMapping(value = "/new_article",method = RequestMethod.POST)
    public Map newArticle(Article article)
    {
        return articleService.newArticle(article);
    }

    //编辑文章
    @RequestMapping(value = "/edit_article",method = RequestMethod.POST)
    public Map editArticle(Article article)
    {
        return articleService.editArticle(article);
    }

    //删除文章
    @RequestMapping(value = "/delete_article",method = RequestMethod.POST)
    public Map deleteArticle(int articleId)
    {
        return articleService.deleteArticle(articleId);
    }

    //获取文章详情
    @RequestMapping(value = "/get_detailed_article",method = RequestMethod.POST)
    public Map getDetailedArticle(int articleId)
    {
        return articleService.getDetailedArticle(articleId);
    }

    //获取标签
    @RequestMapping(value = "/get_label",method = RequestMethod.POST)
    public Map getLabel(int authorId)
    {
        return articleService.getLabel(authorId);
    }

    //获取时间标签
    @RequestMapping(value = "/get_timeLabel",method = RequestMethod.POST)
    public Map getTimeLabel(int authorId)
    {
        return articleService.getTimeLabel(authorId);
    }

    //获取用户文章
    @RequestMapping(value = "/get_article_by_authorId",method = RequestMethod.POST)
    public Map getArticleByAuthorId(int authorId)
    {
        return articleService.getArticleByAuthorId(authorId);
    }

    //按标题查找文章
    @RequestMapping(value = "/get_article_by_title",method = RequestMethod.POST)
    public Map getArticleByTitle(String title)
    {
        return articleService.getArticleByTitle(title);
    }

    //按作者标题查找文章
    @RequestMapping(value = "/get_article_by_authorId_and_title",method = RequestMethod.POST)
    public Map getArticleByAuthorIdAndTitle(int authorId,String title)
    {
        return articleService.getArticleByAuthorIdAndTitle(authorId,title);
    }

    //按作者标签查找文章
    @RequestMapping(value = "/get_article_by_authorId_and_label",method = RequestMethod.POST)
    public Map getArticleByAuthorIdAndLabel(int authorId,String label)
    {
        return articleService.getArticleByAuthorIdAndLabel(authorId,label);
    }

    //按作者时间标签查找文章
    @RequestMapping(value = "/get_article_by_authorId_and_timeLabel",method = RequestMethod.POST)
    public Map getArticleByAuthorIdAndTimeLabel(int authorId,String timeLabel)
    {
        return articleService.getArticleByAuthorIdAndTimeLabel(authorId,timeLabel);
    }

    //获取收藏的文章
    @RequestMapping(value = "/get_collection",method = RequestMethod.POST)
    public Map getCollection(int userId)
    {
        return articleService.getCollection(userId);
    }

    //获取点赞的文章
    @RequestMapping(value = "/get_like",method = RequestMethod.POST)
    public Map getLike(int userId)
    {
        return articleService.getLike(userId);
    }

    //获取关注用户的文章
    @RequestMapping(value = "/get_follow",method = RequestMethod.POST)
    public Map getFollow(int userId)
    {
        return articleService.getFollow(userId);
    }

    //获取最新文章
    @RequestMapping(value = "/get_new_article",method = RequestMethod.POST)
    public Map getNewArticle()
    {
        return articleService.getNewArticle();
    }

    //获取最热文章
    @RequestMapping(value = "/get_hot_article",method = RequestMethod.POST)
    public Map getHotArticle()
    {
        return articleService.getHotArticle();
    }

}