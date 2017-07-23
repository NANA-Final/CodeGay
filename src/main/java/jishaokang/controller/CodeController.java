package jishaokang.controller;

import jishaokang.model.Code;
import jishaokang.model.Like;
import jishaokang.service.CodeService;
import jishaokang.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 代码请求控制
 */
@RestController
@RequestMapping(value = "/back_end/code")
public class CodeController {

    @Autowired
    CodeService codeService;

    //新建代码
    @RequestMapping(value = "/new_code",method = RequestMethod.POST)
    public Map newCode(Code code)
    {
        return codeService.newCode(code);
    }

    //编辑代码
    @RequestMapping(value = "/edit_code",method = RequestMethod.POST)
    public Map editCode(Code code)
    {
        return codeService.editCode(code);
    }

    //删除代码
    @RequestMapping(value = "/delete_code",method = RequestMethod.POST)
    public Map deleteCode(int codeId)
    {
        return codeService.deleteCode(codeId);
    }

    //获取代码详情
    @RequestMapping(value = "/get_code_detail",method = RequestMethod.POST)
    public Map getCodeDetail(int codeId)
    {
        return codeService.getCodeDetail(codeId);
    }

    //按照文件夹获取代码
    @RequestMapping(value = "/get_code_by_folder",method = RequestMethod.POST)
    public Map getCodeByFolder(int folderId)
    {
        return codeService.getCodeByFolder(folderId);
    }
}