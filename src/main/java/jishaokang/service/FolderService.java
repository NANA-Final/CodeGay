package jishaokang.service;

import jishaokang.model.Folder;

import java.util.Map;

/**
 *文件操作逻辑接口
 */
public interface FolderService {

    //新建文件夹
    Map insertFolder(Folder folder);

    //编辑文件夹
    Map editFolder(Folder folder);

    //删除文件夹
    Map deleteFolder(int folderId);

    //获取文件夹详情
    Map getFolderDetail(int folderId);

    //获取子文件夹
    Map getFolderByFatherId(int fatherId);

    //获取文件夹路径
    Map getFolderPath(int folderId);

}