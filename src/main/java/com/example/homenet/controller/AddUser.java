package com.example.homenet.controller;
import com.example.homenet.impl.UserInfoImpl;
import com.example.homenet.pojo.UserInfo;
import org.springframework.web.bind.annotation.*;

import com.example.homenet.impl.UserInfoImpl;
import com.example.homenet.pojo.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;


@RestController
@RequestMapping("/AddUser")
public class AddUser {
    @Resource
    private UserInfoImpl userInfoImpl;

    @GetMapping("/")

    public String showMessage(){
        System.out.println("AddUser");
        return "AddUser2";
    }

    @GetMapping("/webSite")

    public String webSite(@RequestHeader("webSite")String webSite) {

        return "The webSite is " + webSite;

    }

    @RequestMapping("QueryStringTest1")
    public int QueryStringTest1(@RequestParam("name") String name,@RequestParam("pass") String pass){


        UserInfo user = new UserInfo();
        user.setName(name);
//        user.setId("");
        user.setPassword(pass);
        user.setId("8");
        return userInfoImpl.save(user);
//        return "pass is "+ pass+",name is "+ name;
    }

    @GetMapping("/add")
    public int add() {
        UserInfo user = new UserInfo();
        user.setName("李四");
//        user.setId("");
        user.setPassword("1234aaa");
        user.setId("8");
        return userInfoImpl.save(user);
    }

    @PostMapping(value = "/create")
    public int createUser(@RequestBody UserInfo user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        int i =userInfoImpl.save(user);
        System.out.println(i);
        return i;
//        return user;
    }
}

   