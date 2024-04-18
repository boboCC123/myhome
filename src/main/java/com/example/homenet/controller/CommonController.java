package com.example.homenet.controller;





import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
//@RequestMapping("/common")
public class CommonController {
    @PostMapping("/uploads")
    public String upload(MultipartFile myFile) throws IOException {
        myFile.transferTo(new File("D://hello.jpg"));
        return "success";
    }
}