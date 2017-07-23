package jishaokang.controller;

import jishaokang.model.Collection;
import jishaokang.model.Like;
import jishaokang.service.CollectionService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 收藏请求控制
 */
@RestController
@RequestMapping(value = "/back_end/collection")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    //切换收藏状态
    @RequestMapping(value = "/change_collection",method = RequestMethod.POST)
    public Map changeLike(Collection collection)
    {
        return collectionService.changeCollection(collection);
    }

}