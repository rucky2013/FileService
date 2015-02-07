package com.jiaoyiping.fileService.service;

import com.jiaoyiping.fileService.dao.FileDao;
import com.jiaoyiping.fileService.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created with Intellij IDEA
 * USER: Administrator
 * Date: 2015/2/6
 * Time: 0:51
 * To change this template use File | Settings | File Template
 */
@Service
public class FileService {
    @Autowired
    private FileDao fileDao;
    public String addFile(String fileName,String contentType,long size,byte[] data){
        File file = new File();
        file.setFileName(fileName);
        file.setContentType(contentType);
        file.setSize(size);
        file.setData(data);
        file.setCreateTime(new Timestamp(System.currentTimeMillis()));
        file.setId(UUID.randomUUID().toString());
        return fileDao.addFile(file);
    }

}
