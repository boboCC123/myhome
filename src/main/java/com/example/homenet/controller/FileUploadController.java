package com.example.homenet.controller;

import com.example.homenet.impl.ImgImpl;
import com.example.homenet.pojo.Img;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FileUploadController {
    @Resource
    private ImgImpl imgImpl;
    private Img img = new Img();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @PostMapping("/upload")
    public Map<String,Object> fileUpload(MultipartFile file , HttpServletRequest req){
      Map<String,Object> result =new HashMap<>();
      String originName = file.getOriginalFilename();
      if(!originName.endsWith("jpg")){
          result.put("status","error");
          result.put("msg","文件类型不符");

          return result;
      }
      String format = sdf.format(new Date());
      String realPath = req.getServletContext().getRealPath("/")+format;
      File folder = new File(realPath);
      if(!folder.exists()){
          folder.mkdirs();
      }
      String newName = UUID.randomUUID().toString()+".jpg";
     System.out.println("路径："+realPath);
      try{
          file.transferTo(new File(folder,newName));
          String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/"+format+newName;
          result.put("status","success");
          result.put("url",url);
          System.out.println("文件："+url);


          this.img.setImgname(url);

          this.img.setImgpath(realPath);
          this.img.setKind("1");
          this.img.setKindlittle("2");
          int re= this.imgImpl.save(this.img);
          System.out.println("插入信息："+this.img);
          System.out.println("执行结果："+re);

      }catch (IOException e){
          result.put("status","error");
          result.put("msg",e.getMessage());
      }

        return result;

    }
}
