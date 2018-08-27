package com.niudingfeng.financialplanner.interceptor;

import com.niudingfeng.financialplanner.exception.FileUploadTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName FileTypeInterceptor
 * @Description TODO
 * @Author lin
 * @Date 2018/8/24 9:32
 * @Version 1.0
 **/
public class FileTypeInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(FileTypeInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否为文件上传请求
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = multipartRequest.getFileMap();
            Iterator<String> iterator = files.keySet().iterator();
            //对多部件请求资源进行遍历
            while (iterator.hasNext()) {
                String formKey = (String) iterator.next();
                MultipartFile multipartFile = multipartRequest.getFile(formKey);
                String filename = multipartFile.getOriginalFilename();
                //判断是否为限制文件类型
                if (checkFile(filename)) {
                    return true;
                }
            }
            throw new FileUploadTypeException("图片格式不正确!");
        }
        log.info("访问被FileTypeInterceptor拦截");
        return false;
    }

    private boolean checkFile(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }


}
