package com.jiaoyiping.fileService.dao;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jiaoyiping.fileService.domain.File;
import com.jiaoyiping.fileService.util.Const;
import com.jiaoyiping.fileService.util.MongoUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created with Intellij IDEA
 * USER: Administrator
 * Date: 2015/2/6
 * Time: 0:50
 * To change this template use File | Settings | File Template
 */
@Repository
public class FileDao {
    /**
     *
     * @param file
     * @return
     */
    public String addFile(File file){
        DBObject dbObject = fileToDBObj(file);
        MongoUtil.getDB().getCollection(Const.fileCollectionName).save(dbObject);
        return file.getId();
    }

    public void deleteFile(){

    }
    public File getFile(String fId){
        return null;
    }

    private static final DBObject fileToDBObj(File file){
        DBObject dbObject = new BasicDBObject();
        dbObject.put("fileName",file.getFileName());
        dbObject.put("contentType",file.getContentType());
        dbObject.put("size",file.getSize());
        dbObject.put("data",file.getData());
        dbObject.put("createTime",file.getCreateTime());
        dbObject.put("id",file.getId());
        return dbObject;
    }
}
