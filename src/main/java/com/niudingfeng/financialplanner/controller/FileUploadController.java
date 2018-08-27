package com.niudingfeng.financialplanner.controller;

import com.niudingfeng.financialplanner.utils.fileutil.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    /**
     * 跳转到文件上传页面
     *
     */
    @RequestMapping("test")
    @ResponseBody
    public String toUpload(){
        return "test";
    }

    /**
     *
     * @param file 要上传的文件
     *
     */
    @RequestMapping("fileUpload")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("fileName") MultipartFile file){

        // 要上传的目标文件存放路径
//        String localPath = "E:/Develop/Files/Photos";
        // 上传成功或者失败的提示
        String msg = "";
        String returnFileName = null;
        if ((returnFileName = FileUtils.upload(file,path, file.getOriginalFilename()))!=null){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";

        }
        HashMap<String, Object> map = new HashMap<>();
        // 显示图片
        map.put("msg", msg);
        map.put("fileName", returnFileName);

        return map;
    }

    /**
     * 显示单张图片
     *
     */
    @RequestMapping("show/{fileName:.+}")
    public ResponseEntity showPhotos(@PathVariable String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
