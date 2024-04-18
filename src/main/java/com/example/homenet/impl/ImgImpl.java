package com.example.homenet.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.homenet.Service.ImgService;
import com.example.homenet.mapper.ImgMapper;
import com.example.homenet.pojo.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    public Img getImgById(int id){
        QueryWrapper<Img> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return imgMapper.selectOne(wrapper);
    }

    public Img getImgByKind(String kind){
        QueryWrapper<Img> wrapper = new QueryWrapper<>();
        wrapper.eq("kind", kind);
        return imgMapper.selectOne(wrapper);
    }

    public List<Img> getImgsByKindAndKindlittle(String kind,String kindlittle){
        QueryWrapper<Img> wrapper = new QueryWrapper<>();
        wrapper.eq("kind", kind);
        wrapper.and(queryWrapper -> queryWrapper.eq("kindlittle", kindlittle));

        return imgMapper.selectList(wrapper);
    }

    public List<Img> findAllImgs(){
        return imgMapper.selectList(new QueryWrapper<>());
    }

    public int save(Img img){return imgMapper.insert(img);}

}
