package com.example.homenet.controller;

import com.example.homenet.impl.ImgImpl;
import com.example.homenet.pojo.Img;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Comic")
public class ImgController {

    @Resource
    private ImgImpl imgImpl;

    @RequestMapping("/{kind}/{kindlittle}")
    public List<Img> getImgsByKindAndKindlittle(@PathVariable String kind, @PathVariable String kindlittle){
        System.out.println("测试"+kind+"  ---  "+kindlittle);
        return imgImpl.getImgsByKindAndKindlittle(kind,kindlittle);
    }

    @GetMapping("/all")
    public List<Img> getData()
    {
        return imgImpl.findAllImgs();
    }

}
