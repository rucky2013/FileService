package com.jiaoyiping.fileService.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * USER: Administrator
 * Date: 2015/2/6
 * Time: 0:48
 * To change this template use File | Settings | File Template
 */
public class File implements Serializable{
    private String id;
    private String fileName;
    private String contentType;
    private long size;
    private byte[] data;
    private Timestamp createTime;
    public File(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
