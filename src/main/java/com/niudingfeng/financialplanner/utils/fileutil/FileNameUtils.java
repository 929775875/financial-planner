package com.niudingfeng.financialplanner.utils.fileutil;

public class FileNameUtils {

    /**
     * 获取文件后缀
     *
     * @param fileName
     *
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 生成新的文件名
     *
     * @param fileOriginName 源文件名
     *
     */
    public static String getFileName(String fileOriginName) {
        //生成全新名
        // return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
        //保留原名
        return UUIDUtils.getUUID() + "-" + fileOriginName;
    }

}
