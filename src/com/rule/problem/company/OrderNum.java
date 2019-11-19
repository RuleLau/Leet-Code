package com.rule.problem.company;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: rule
 * @date: 2019-11-06 22:45
 **/
public class OrderNum {

    /**
     * 先分治排序然后保存中间结果，然后多路归并排序
     */
    private static final String FILE_PATH_ONE = "E:\\Algorithm-Study\\data\\6";
    private static final String FILE_PATH_TWO = "E:\\Algorithm-Study\\data\\7";
    private static final String FILE_PATH_THREE = "E:\\Algorithm-Study\\data\\8";
    private static final String FILE_PATH_FOUR = "E:\\Algorithm-Study\\data\\9";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        Map<String, Integer> skus = new HashMap<>();
        File folder = new File(FILE_PATH_ONE);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            Document doc = readFiles(files[i]);
            NodeList orderList = doc.getElementsByTagName("order");
            for (int j = 0; j < orderList.getLength(); j++) {
                String skuName = doc.getElementsByTagName("sku").item(j).getFirstChild().getNodeValue();
                String skuNum = doc.getElementsByTagName("num").item(j).getFirstChild().getNodeValue();
                if (!skus.containsKey(skuName)) {
                    skus.put(skuName, Integer.valueOf(skuNum));
                } else {
                    Integer oldNum = skus.get(skuName);
                    skus.put(skuName, Integer.valueOf(skuNum) + oldNum);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("spend time about " + (end - start));
    }

    public static Document readFiles(File file) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }
}
