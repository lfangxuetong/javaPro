package com.baoxian.edi.util.dom4j;

import java.util.*;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.QName;

/**
 * Created by liwucai on 2016/2/22.
 */
public class Dom4jUtils {

    /**
     * Dom2Map
     *
     * @param doc
     * @return Map
     */
    public static Map Dom2Map(Document doc) {
        Map map = new HashMap();
        if (doc == null)
            return map;
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
            Element element = (Element) iterator.next();
            String name = element.getName();
            QName nameqname = element.getQName();
            String getQualifiedName = element.getQualifiedName();
            Object namespace = element.getNamespace();
            Object getNamespaceForPrefix = element.getNamespaceForPrefix("province");
            Object getData = element.getData();
            Object getNamespaceURI = element.getNamespaceURI();
            Attribute attribute = element.attribute("code");
            String atname = attribute.getName();

            List list = element.elements();
            if (list.size() > 0) {
                map.put(element.getName(), Dom2Map(element));
            } else {
                map.put(element.getName(), element.getText());
            }
        }
        return map;
    }

    /**
     * Dom2Map
     *
     * @param elements
     * @return Map
     */
    public static Map Dom2Map(Element elements) {
        Map map = new HashMap();
        List list = elements.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List mapList = new ArrayList();

                if (iter.elements().size() > 0) {
                    Map m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), m);
                    }
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = (List) obj;
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else {
            map.put(elements.getName(), elements.getText());
        }
        return map;
    }

}
