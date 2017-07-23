package jishaokang.dao;

import jishaokang.model.Folder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对文件夹表的操作
 */
@Repository
public interface FolderDao {

    //插入文件夹
    void insert(Folder folder);

    //更改文件夹
    void update(Folder folder);

    //删除文件夹
    void delete(int FolderId);

    //获取文件夹详情
    Folder selectByFolderId(int folderId);

    //获取子文件夹
    List<Folder> selectByFatherId(int fatherId);

}