package jishaokang.controller.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 代码视图控制
 */
@Controller
@RequestMapping(value = "/code")
public class CodePageController {

    //代码主页视图
    @RequestMapping(value = "")
    public String homepage()
    {
        return "code/homepage";
    }

    //代码详情视图
    @RequestMapping(value = "code_detail")
    public String codeDetail()
    {
        return "code/code_detail";
    }

    //新建代码视图
    @RequestMapping(value = "new_code")
    public String newCode(int folderId)
    {
        return "code/new_code";
    }

    //编辑代码视图
    @RequestMapping(value = "edit_code")
    public String editCode(int codeId)
    {
        return "code/edit_code";
    }

    //新建文件夹视图
    @RequestMapping(value = "new_folder")
    public String newFolder(int fatherId)
    {
        return "code/new_folder";
    }

    //编辑文件夹视图
    @RequestMapping(value = "edit_folder")
    public String editFolder(int folderId)
    {
        return "code/edit_folder";
    }

}