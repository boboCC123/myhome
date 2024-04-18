package com.example.homenet.mapper;

import com.example.homenet.pojo.Img;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
@Repository
public interface ImgMapper extends BaseMapper<Img>{
}
