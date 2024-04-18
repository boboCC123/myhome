package com.example.homenet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.example.homenet.mapper")
public class HomenetApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomenetApplication.class, args);
    }

}
