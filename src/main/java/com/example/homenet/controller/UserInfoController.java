package com.example.homenet.controller;


import com.example.homenet.impl.UserInfoImpl;
import com.example.homenet.pojo.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserInfoController {

    @Resource
    private UserInfoImpl userInfoImpl;


    @GetMapping("/")
    public String getUser()
    { return "test";
    }

    @RequestMapping("/{id}")
    public UserInfo getUserInfoById(@PathVariable String id){

        return userInfoImpl.getUserInfoById(id);
    }

    @GetMapping("/all")
    public List<UserInfo> getData()
    {
        return userInfoImpl.findAllUsers();
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

}
