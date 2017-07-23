package jishaokang.service.impl;

import com.sun.org.apache.xpath.internal.SourceTree;
import jishaokang.dao.ArticleDao;
import jishaokang.dao.NoticeDao;
import jishaokang.dao.UserDao;
import jishaokang.model.Article;
import jishaokang.model.Notice;
import jishaokang.model.User;
import jishaokang.service.ArticleService;
import jishaokang.service.UserService;
import jishaokang.util.EscapeString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章操作逻辑
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    NoticeDao noticeDao;

    //新建文章
    @Override
    public Map newArticle(Article article) {
        article.setContent(EscapeString.transfer(article.getContent()));
        articleDao.insert(article);
        Notice notice = new Notice();
        notice.setContent("新建文章:"+article.getTitle());
        notice.setNoticeTime(article.getDetailedTime());
        notice.setNoticerId(article.getAuthorId());
        notice.setNoticeUrl("http://localhost:8081/article/article_detail?articleId="+article.getArticleId());
        noticeDao.insert(notice);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    //编辑文章
    @Override
    public Map editArticle(Article article) {
        article.setContent(EscapeString.transfer(article.getContent()));
        articleDao.update(article);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    //删除文章
    @Override
    public Map deleteArticle(int articleId) {
        articleDao.delete(articleId);
        Map map = new HashMap();
        map.put("message","succeed");
        return map;
    }

    //获取文章详情
    @Override
    public Map getDetailedArticle(int articleId) {
        Article article = articleDao.selectByArticleId(articleId);
        Map map = new HashMap();
        if (article == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询文章完毕");
            map.put("data",article);
        }
        return map;
    }

    //获取标签
    @Override
    public Map getLabel(int authorId) {
        List<Article> articles = articleDao.selectByAuthorId(authorId);
        Map<String,Integer> labels = new HashMap<String,Integer>();
        for (int i = 0; i < articles.size(); i++) {
            String label = articles.get(i).getLabel();
            if (labels.containsKey(label)) {
                int val = labels.get(label) + 1;
                labels.put(label, val);
            } else {
                labels.put(label, 1);
            }
        }
        Map map = new HashMap();
        if (labels == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询标签完毕");
            map.put("data",labels);
        }
        return map;
    }

    //获取时间标签
    @Override
    public Map getTimeLabel(int authorId) {
        List<Article> articles = articleDao.selectByAuthorId(authorId);
        Map<String,Integer> TimeLabels = new HashMap<String,Integer>();
        for (int i = 0; i < articles.size(); i++) {
            String TimeLabel = articles.get(i).getTimeLabel();
            if (TimeLabels.containsKey(TimeLabel)) {
                int val = TimeLabels.get(TimeLabel) + 1;
                TimeLabels.put(TimeLabel, val);
            } else {
                TimeLabels.put(TimeLabel, 1);
            }
        }
        Map map = new HashMap();
        if (TimeLabels == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询时间标签完毕");
            map.put("data",TimeLabels);
        }
        return map;
    }

    //获取用户的文章
    @Override
    public Map getArticleByAuthorId(int authorId) {
        List<Article> articles = articleDao.selectByAuthorId(authorId);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //按标题获取文章
    public Map getArticleByTitle(String title) {
        List<Article> articles = articleDao.selectByTitle(title);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //按用户标题查找文章
    @Override
    public Map getArticleByAuthorIdAndTitle(int authorId, String title) {
        Map requestMap = new HashMap();
        requestMap.put("authorId",authorId);
        requestMap.put("title",title);
        List<Article> articles = articleDao.selectByAuthorIdAndTitle(requestMap);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询文章标题完毕");
            map.put("data",articles);
        }
        System.out.println(map);
        return map;
    }

    //按用户标签查找文章
    @Override
    public Map getArticleByAuthorIdAndLabel(int authorId,String label) {
        Map requestMap = new HashMap();
        requestMap.put("authorId",authorId);
        requestMap.put("label",label);
        List<Article> articles = articleDao.selectByAuthorIdAndLabel(requestMap);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询标签分类文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //按用户时间标签查找文章
    @Override
    public Map getArticleByAuthorIdAndTimeLabel(int authorId,String timeLabel) {
        Map requestMap = new HashMap();
        requestMap.put("authorId",authorId);
        requestMap.put("timeLabel",timeLabel);
        List<Article> articles = articleDao.selectByAuthorIdAndTimeLabel(requestMap);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询时间标签分类文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //获取收藏文章
    @Override
    public Map getCollection(int userId) {
        List<Article> articles = articleDao.selectCollectionByUserId(userId);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到收藏信息");
        }else{
            map.put("message","查询收藏文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //获取点赞文章
    @Override
    public Map getLike(int userId) {
        List<Article> articles = articleDao.selectLikeByUserId(userId);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到点赞信息");
        }else{
            map.put("message","查询点赞文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //获取最新文章
    @Override
    public Map getNewArticle() {
        List<Article> articles = articleDao.selectByTime();
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询最新文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //获取最热文章
    @Override
    public Map getHotArticle() {
        List<Article> articles = articleDao.selectByLike();
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到信息");
        }else{
            map.put("message","查询最热文章完毕");
            map.put("data",articles);
        }
        return map;
    }

    //获取关注用户的文章
    @Override
    public Map getFollow(int userId) {
        List<Article> articles = articleDao.selectFollowByUserId(userId);
        Map map = new HashMap();
        if (articles == null){
            map.put("message","未查询到关注信息");
        }else{
            map.put("message","查询关注文章完毕");
            map.put("data",articles);
        }
        return map;
    }

}