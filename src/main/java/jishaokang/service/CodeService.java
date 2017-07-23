package jishaokang.service;

import jishaokang.model.Code;
import jishaokang.model.Like;

import java.util.Map;

/**
 * 代码操作逻辑接口
 */
public interface CodeService {

    //新建代码
    Map newCode(Code code);

    //编辑代码
    Map editCode(Code code);

    //删除代码
    Map deleteCode(int codeId);

    //获取代码详情
    Map getCodeDetail(int codeId);

    //按照目录获取代码
    Map getCodeByFolder(int folderId);

}