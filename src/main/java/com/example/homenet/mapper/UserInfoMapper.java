package com.example.homenet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.homenet.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
