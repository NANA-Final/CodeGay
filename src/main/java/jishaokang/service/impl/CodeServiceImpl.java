package jishaokang.service.impl;

import jishaokang.dao.CodeDao;
import jishaokang.model.Code;
import jishaokang.service.CodeService;
import jishaokang.util.EscapeString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码操作逻辑
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeDao codeDao;

    //新建代码
    @Override
    public Map newCode(Code code) {
        code.setContent(EscapeString.transfer(code.getContent()));
        codeDao.insert(code);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //编辑代码
    @Override
    public Map editCode(Code code) {
        codeDao.update(code);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //删除代码
    @Override
    public Map deleteCode(int codeId) {
        codeDao.delete(codeId);
        Map map = new HashMap();
        map.put("message", "succeed");
        return map;
    }

    //获取代码详情
    @Override
    public Map getCodeDetail(int codeId) {
        Code code = codeDao.selectByCodeId(codeId);
        Map map = new HashMap();
        if (code == null) {
            map.put("message", "未查询到代码");
        } else {
            map.put("message", "查询代码完毕");
            map.put("data", code);
        }
        return map;
    }

    //按照目录获取代码
    @Override
    public Map getCodeByFolder(int folderId) {
        List<Code> code = codeDao.selectByFolderId(folderId);
        Map map = new HashMap();
        if (code == null){
            map.put("message","未查询到代码");
        }else{
            map.put("message","查询代码完毕");
            map.put("data",code);
        }
        return map;
    }

}