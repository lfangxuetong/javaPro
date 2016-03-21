package com.baoxian.edi.util;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by liwucai on 2016/2/18.
 *
 */
public class FileUtils {
    /**
     * IO 方式读取 文本文件 的字符串
     * @param filePath 文件的路径
     * @param encoding 文件的编码
     * @return 返回文件的字符串
     * @throws Exception
     */
    public static String fileToStr_func1(String filePath, String encoding) throws Exception {
        String fileContent = null;
        File file = new File(filePath);
        Long size = file.length();
        byte[] buff = new byte[size.intValue()];
        FileInputStream fs = new FileInputStream(file);
        fs.read(buff);
        fs.close();
        fileContent = new String(buff,encoding); // "UTF-8"
        return fileContent;
    }

    /**
     * 使用apache commons 包读取 文本文件 的字符串
     * @param filePath 文件的路径
     * @param encoding 文件的编码
     * @return 返回文件的字符串
     * @throws Exception
     */
    public static String fileToStr_func2(String filePath,String encoding) throws Exception {
        String ctx="";
        try {
            ctx = org.apache.commons.io.FileUtils.readFileToString(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ctx;
    }
}




