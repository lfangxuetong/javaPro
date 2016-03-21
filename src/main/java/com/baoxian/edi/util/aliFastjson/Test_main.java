package com.baoxian.edi.util.aliFastjson;

import com.alibaba.fastjson.JSONObject;
import com.baoxian.edi.util.FileUtils;

import java.util.Map;

/**
 * Created by liwucai on 2016/2/18.
 */
public class Test_main {

    /* 使用 alibaba fastjson: 对象序列化为 JSON串，JSON串反序列化为对象 */
    public static void main(String[] args){
        String path="E:\\test_can_d\\javaPro\\src\\main\\java\\com\\baoxian\\edi\\util\\aliFastjson\\json_text.txt";

        String string_1 = "";
        try {
            string_1 = FileUtils.fileToStr_func1(path, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("从文件读取的json串， string_1 = " + string_1);

        String string_2 = "";
        try {
            string_2 = FileUtils.fileToStr_func2(path, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("从文件读取的json串， string_2 = " + string_2);

        Map map1 = JSONObject.parseObject(string_1, Map.class);
        Map map2 = JSONObject.parseObject(string_2, Map.class);
        System.out.println("\njson串 转 map对象, map1 = " + map1);
        System.out.println("json串 转 map对象, map2 = " + map2);
        String jsonStr_1 = JSONObject.toJSONString(map1);
        System.out.println("map对象 转 json串, jsonStr_1 = " + jsonStr_1);

        String jsonString = "{'name':'李武才1'}";
        System.out.println("\njson串 = " + jsonString);
        Person per1 = JSONObject.parseObject(jsonString, Person.class); //指定类的class，类定义默认构造
        System.out.println("json串 转 自定义类Person 对象, per1 = " + per1 + " ,per1.name = " + per1.name);
        String jsonStr_2 = JSONObject.toJSONString(per1);
        System.out.println("自定义类Person对象 转 json串, jsonStr_2 = " + jsonStr_2);
    }
}
