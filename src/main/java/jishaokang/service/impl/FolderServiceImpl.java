package jishaokang.service.impl;

import jishaokang.dao.FolderDao;
import jishaokang.model.Folder;
import jishaokang.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件夹操作逻辑
 */
@Service("folderService")
public class FolderServiceImpl implements FolderService {

    @Autowired
    FolderDao folderDao;

    //新建文件夹
    @Override
    public Map insertFolder(Folder folder) {
        folderDao.insert(folder);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //修改文件夹
    @Override
    public Map editFolder(Folder folder) {
        folderDao.update(folder);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除文件夹
    @Override
    public Map deleteFolder(int folderId) {
        folderDao.delete(folderId);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //查询文件夹详情
    @Override
    public Map getFolderDetail(int folderId) {
        Folder folder = folderDao.selectByFolderId(folderId);
        Map map = new HashMap();
        if (folder == null) {
            map.put("message", "未查询到文件夹");
        } else {
            map.put("message", "查询文件夹完毕");
            map.put("data", folder);
        }
        return map;
    }

    //获取子文件夹
    @Override
    public Map getFolderByFatherId(int fatherId) {
        List<Folder> folders = folderDao.selectByFatherId(fatherId);
        Map map = new HashMap();
        if (folders == null){
            map.put("message","未查询到文件夹");
        }else{
            map.put("message","查询文件夹完毕");
            map.put("data",folders);
        }
        return map;
    }

    //获取文件夹路径
    @Override
    public Map getFolderPath(int folderId) {
        Folder folder;
        List<Folder> folders = new ArrayList<Folder>();
        do{
            folder = folderDao.selectByFolderId(folderId);
            folders.add(folder);
            folderId = folder.getFatherId();
        }while (folderId!=0);
        Map map = new HashMap();
        if (folder == null) {
            map.put("message", "未查询到路径");
        } else {
            map.put("message", "查询路径完毕");
            map.put("data", folders);
        }
        return map;
    }

}