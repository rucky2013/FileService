package com.jiaoyiping.fileService.dao;

import com.jiaoyiping.fileService.domain.File;
import com.jiaoyiping.fileService.util.Const;
import com.jiaoyiping.fileService.util.MongoUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

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
    public File getFile(String fId) {
        DBObject fields = new BasicDBObject();
        fields.put("id",fId);
        DBObject object= MongoUtil.getDB().getCollection(Const.fileCollectionName).findOne(fields);
//        DBObject object= MongoUtil.getDB().getCollection(Const.fileCollectionName).findOne(new BasicDBObject("id", fId), fields);
        return dbObjToFile(object);
    }

    private static DBObject fileToDBObj(File file){
        DBObject dbObject = new BasicDBObject();
        dbObject.put("fileName",file.getFileName());
        dbObject.put("contentType",file.getContentType());
        dbObject.put("size",file.getSize());
        dbObject.put("data",file.getData());
        dbObject.put("createTime",file.getCreateTime());
        dbObject.put("id",file.getId());
        return dbObject;
    }
    private static File dbObjToFile(DBObject object){
        File file = new File();
        file.setId((String )object.get("id"));
        file.setCreateTime(new Timestamp(((Date)object.get("createTime")).getTime()));
        file.setData((byte[])object.get("data"));
        file.setContentType((String)object.get("contentType"));
        file.setFileName((String)object.get("fileName"));
        file.setSize((long)object.get("size"));
        return file;
    }


}
