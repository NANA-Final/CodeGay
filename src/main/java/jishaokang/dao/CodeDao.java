package jishaokang.dao;

import jishaokang.model.Code;
import jishaokang.model.Like;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对代码表的操作
 */
@Repository
public interface CodeDao {

    //新建代码
    void insert(Code code);

    //更新代码
    void update(Code code);

    //删除代码
    void delete(int codeId);

    //按照codeID查找代码
    Code selectByCodeId(int codeId);

    //按照文件夹目录查找代码
    List<Code> selectByFolderId(int folderId);

}