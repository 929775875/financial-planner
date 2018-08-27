package com.niudingfeng.financialplanner.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>
 * 
 * </p>
 *
 * @author lin123
 * @since 2018-08-24
 */
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;
    private byte[] imgBlob;


    public User() {
    }

    public User(Integer userid, byte[] imgBlob) {
        this.userid = userid;
        this.imgBlob = imgBlob;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public byte[] getImgBlob() {
        return imgBlob;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setImgBlob(byte[] imgBlob) {
        this.imgBlob = imgBlob;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", imgBlob=" + Arrays.toString(imgBlob) +
                '}';
    }
}
