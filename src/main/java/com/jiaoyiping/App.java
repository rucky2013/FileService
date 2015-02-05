package com.jiaoyiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 设计说明：1.小文件存储在MongoDB里,生成一个全局唯一的串码来表示
 *          2.外系统使用本服务做文件存储引擎(上传之后保存文件的串码)
 *          3.外系统使用REST接口对文件进行上传、下载、查询、删除
 */
@SpringBootApplication
@RequestMapping("/file")
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("SUCCESS");
        out.flush();
        out.close();
    }
    //根据文件标识符来查询文件()
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public void getFile(HttpServletRequest request, HttpServletResponse response){

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
