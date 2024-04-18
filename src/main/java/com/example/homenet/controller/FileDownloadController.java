package com.example.homenet.controller;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/download")
public class FileDownloadController {


    @RequestMapping("/")
    public String down(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表单传来的名"+fileName);

        //获取文件地址
//        String realPath = request.getSession(true).getServletContext().getRealPath("download");
        //test
        String realPath = "http://localhost:8083/2023/05/21/f567781a-2f44-41af-868d-075c0b3e8348.jpg";
        //把服务器中文件读取到内存中
        FileInputStream fis = new FileInputStream(new File(realPath,fileName));
        //设置下载的类型
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        //获取输出流
        ServletOutputStream os = response.getOutputStream();
        //复制
        IOUtils.copy(fis,os);
        //关闭资源
        fis.close();
        os.close();

        return null;
    }

}
