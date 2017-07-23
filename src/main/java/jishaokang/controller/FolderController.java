package jishaokang.controller;

import jishaokang.model.Folder;
import jishaokang.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文件夹请求控制
 */
@RestController
@RequestMapping(value = "/back_end/folder")
public class FolderController {

    @Autowired
    FolderService folderService;

    //新建文件夹
    @RequestMapping(value = "/new_folder",method = RequestMethod.POST)
    public Map newFolder(Folder folder)
    {
        return folderService.insertFolder(folder);
    }

    //编辑文件夹
    @RequestMapping(value = "/edit_folder",method = RequestMethod.POST)
    public Map editFolder(Folder folder)
    {
        return folderService.editFolder(folder);
    }

    //删除文件夹
    @RequestMapping(value = "/delete_folder",method = RequestMethod.POST)
    public Map deleteFolder(int folderId)
    {
        return folderService.deleteFolder(folderId);
    }

    //获取文件夹详情
    @RequestMapping(value = "/get_folder_detail",method = RequestMethod.POST)
    public Map getFolderDetail(int folderId)
    {
        return folderService.getFolderDetail(folderId);
    }

    //获取子文件夹
    @RequestMapping(value = "/get_folder_by_fatherId",method = RequestMethod.POST)
    public Map getFolderByFatherId(int fatherId)
    {
        return folderService.getFolderByFatherId(fatherId);
    }

    //获取文件夹路径
    @RequestMapping(value = "/get_folder_path",method = RequestMethod.POST)
    public Map getFolderPath(int folderId)
    {
        return folderService.getFolderPath(folderId);
    }
}