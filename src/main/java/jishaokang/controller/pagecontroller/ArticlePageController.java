package jishaokang.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文章视图控制
 */
@Controller
@RequestMapping(value = "/article")
public class ArticlePageController {

    //主页视图
    @RequestMapping(value = "")
    public String homepage()
    {
        return "article/homepage";
    }

    //新建文章视图
    @RequestMapping(value = "/new_article")
    public String newArticle()
    {
        return "article/new_article";
    }

    //编辑文章视图
    @RequestMapping(value = "/edit_article",method = RequestMethod.GET)
    public String editArticle(int articleId)
    {
        return "article/edit_article";
    }

    //获取文章视图
    @RequestMapping(value = "/get_article",method = RequestMethod.GET)
    public String getArticle(int authorId)
    {
        return "article/get_article";
    }

    //文章详情视图
    @RequestMapping(value = "/article_detail",method = RequestMethod.GET)
    public String articleDetail(int articleId)
    {
        return "article/article_detail";
    }

}