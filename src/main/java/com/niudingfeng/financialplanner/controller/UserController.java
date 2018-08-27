package com.niudingfeng.financialplanner.controller;


import com.niudingfeng.financialplanner.entity.User;
import com.niudingfeng.financialplanner.response.Response;
import com.niudingfeng.financialplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lin123
 * @since 2018-08-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//
    @RequestMapping("users")
    public List<User> getUser() {
        return userService.selectList(null);
    }

    /**
     * 上传用户头像
     * @param file
     * @return
     */
    @RequestMapping("upload")
    public Response imgUpLoad(@RequestParam("fileName") MultipartFile file) {
        byte[] bytes = new byte[(int) file.getSize()];
        User user = new User();
        try {
            bytes = file.getBytes();
            user.setImgBlob(bytes);
            userService.insert(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Response().success();
    }

    /**
     * 根据用户id获取用户头像
     * @param userid
     * @return
     */
    @RequestMapping("getimg/{userid}")
    public ResponseEntity<byte[]> getimg(@PathVariable String userid) {
        User user = userService.selectById(userid);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(user.getImgBlob(),headers, HttpStatus.OK);
    }
}


