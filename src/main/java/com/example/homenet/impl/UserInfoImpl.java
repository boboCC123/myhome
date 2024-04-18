package com.example.homenet.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.homenet.Service.UserInfoService;
import com.example.homenet.mapper.UserInfoMapper;
import com.example.homenet.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoById(String id){
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return userInfoMapper.selectOne(wrapper);
    }


    public List<UserInfo> findAllUsers(){
        return userInfoMapper.selectList(new QueryWrapper<>());
    }


    public int save(UserInfo userInfo){return userInfoMapper.insert(userInfo);}
}
