package com.sam.dto;

/**
 * @Author: huangxin
 * @Date: Created in 下午4:48 2018/2/26
 * @Description:
 */
public class FileInfo {

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

}
