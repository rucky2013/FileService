package com.jiaoyiping.fileService;

import com.jiaoyiping.fileService.domain.File;
import com.jiaoyiping.fileService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 设计说明：1.小文件存储在MongoDB里,生成一个全局唯一的串码来表示
 *          2.外系统使用本服务做文件存储引擎(上传之后保存文件的串码)
 *          3.外系统使用REST接口对文件进行上传、下载、查询、删除
 */
@SpringBootApplication
@RequestMapping("/file")
public class App extends SpringBootServletInitializer {
    @Autowired
    private FileService fileService;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody String addFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        List<Part> partList = (List<Part>)request.getParts();
        Part filePart = request.getPart("file");
        String  fileName = filePart.getSubmittedFileName();//文件名
        long size = filePart.getSize();
        String contentType = filePart.getContentType();
        byte[] data = new byte[(int)size];
        filePart.getInputStream().read(data);
        String fileUUID = this.fileService.addFile(fileName,contentType,size,data);
        return fileUUID;
    }
    //根据文件标识符来查询文件()
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public @ResponseBody File getFile(HttpServletRequest request, HttpServletResponse response){
        String fileId = request.getParameter("id");
        if(fileId != null){
            return this.fileService.getFile(fileId);
        }
        return null;
    }

    //下载文件
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public String downloadFile(){
        return null;
    }

    //根据文件标识符来删除文件
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public void deleteFile(){

    }

}
