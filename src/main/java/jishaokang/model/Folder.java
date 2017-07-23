package jishaokang.model;

import lombok.Data;

/**
 * 文件夹类
 */
@Data
public class Folder {

    /*文件夹Id*/
    private Integer folderId;
    /*上级目录ID*/
    private Integer fatherId;
    /*新建文件夹ＩＤ*/
    private String folderTime;
    /*文件夹名称*/
    private String folderName;

}
