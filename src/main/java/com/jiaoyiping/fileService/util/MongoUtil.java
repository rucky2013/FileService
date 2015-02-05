package com.jiaoyiping.fileService.util;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * Created with Intellij IDEA
 * USER: Administrator
 * Date: 2015/2/6
 * Time: 1:07
 * To change this template use File | Settings | File Template
 */
public class MongoUtil {
    private static Logger logger = LoggerFactory.getLogger(MongoUtil.class);
    private static Mongo mongo;

    static {
        try {
            mongo = new Mongo();
        } catch (UnknownHostException e) {
            logger.error("初始化MongoDB失败",e);
        }
    }

    //这里的DBname是写死的
    public DB getDB() {
        DB db = null;
        db = mongo.getDB(Const.MongoDBdbName);
        return db;
    }
}
