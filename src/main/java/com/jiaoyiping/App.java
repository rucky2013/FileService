package com.jiaoyiping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello world!
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
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
}
