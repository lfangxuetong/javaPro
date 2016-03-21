package com.baoxian.edi.util.dom4j;

import com.baoxian.edi.util.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import java.util.Map;

/**
 * Created by liwucai on 2016/2/22.
 */
public class Dom4jUtils_Test {
    public static void main(String[] args) {
        String filePath = "E:\\test_can_d\\javaPro\\src\\main\\java\\com\\baoxian\\edi\\util\\dom4j\\xml.xml";
        try {
            String xml = FileUtils.fileToStr_func1(filePath, "UTF-8");
            Document document = DocumentHelper.parseText(xml);
            Map map = Dom4jUtils.Dom2Map(document);
            System.out.println("xml 转成 map = " + map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
