package jishaokang.model;

import lombok.Data;

/**
 * 代码类
 */
@Data
public class Code {

    /*代码ID*/
    private Integer codeId;
    /*代码文件名称*/
    private String codeName;
    /*代码内容*/
    private String content;
    /*所属文件夹名称*/
    private Integer folderId;
    /*新建代码时间*/
    private String codeTime;

}
