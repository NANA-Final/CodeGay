package jishaokang.controller;

import jishaokang.model.Article;
import jishaokang.model.Collection;
import jishaokang.model.Like;
import jishaokang.service.ArticleService;
import jishaokang.service.CollectionService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 点赞请求控制
 */
@RestController
@RequestMapping(value = "/back_end/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    //切换点赞状态
    @RequestMapping(value = "/change_like",method = RequestMethod.POST)
    public Map changeLike(Like like)
    {
        return likeService.changeLike(like);
    }


}