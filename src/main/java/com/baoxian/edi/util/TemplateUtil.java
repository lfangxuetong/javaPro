package com.baoxian.edi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by liwucai on 2016/2/18.
 */
public class TemplateUtil {
    public static String fileToStr_func1(String filePath,String encoding) throws Exception {
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

    public static String fileToStr_func2(String filePath,String encoding) throws Exception {
        String ctx="";
        try {
            ctx = org.apache.commons.io.FileUtils.readFileToString(new File(filePath), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ctx;
    }

    public static void main(String[] args){
        String path="E:\\test_can_d\\javaPro\\src\\main\\java\\com\\baoxian\\edi\\util\\json_text.txt";

        try {
            System.out.println("ctx = " + fileToStr_func1(path, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("jsonString = " + TemplateUtil.fileToStr_func2(path, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Map map = JSONObject.parseObject(ss, Map.class);
    }
}



