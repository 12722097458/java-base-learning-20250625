package com.ityj.advance.collection;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    @Test
    public void testHashMap(){
        Map<String,String> map = new HashMap<>();
        map.put("A","1"); // newCap=16 newThr = 16 * 0.75 = 12
        map.put("B","2");
        map.put("C","3");
        map.put("D","4");
        map.put("E","5");
        map.put("F","6");
        map.put("G","7");
        map.put("H","8");
        map.put("I","9");
        map.put("J","10");
        map.put("K","11");
        map.put("L","12");
        map.put("M","13"); // 第13次add时会扩容，newCap = oldCap << 1 = 32， newThr = oldThr << 1 = 24   扩容完需要把old node[] 复制到 new node[]
        map.put("N","14");
        map.put("O","15");
        map.put("P","16");
        map.put("P","hhhhh");
        map.put(null,"hhhhh");
        map.put("Q","17");
    }


    //  重写了HashSet里的   Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {}
    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("B","2");
        map.put("C","123");
        map.put("A","1");
        map.put("B","444");
    }

    @Test
    public void testTreeMap(){
        Map<String,String> map = new TreeMap<>();
        map.put("A","1");
    }

    @Test
    public void testHashTable(){
        Map<String,String> map = new Hashtable<>();
        map.put("A","1");
    }


    @Test
    public void testHashTable2(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("A","1");
    }

    /*
    * bucket(桶/数组)
    * 0
    * 1
    * 2
    * 3      19  3  35
    * 4
    * 5
    * 6
    * 7      7
    * 8
    * 9
    * 10
    * 11     11  43  59
    * 12
    * 13
    * 14
    * 15
    * */
    @Test
    public void testTraversal() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(7, "");
        map.put(11, "a");
        map.put(43, "b");
        map.put(59, "c");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
    }

    /*
    *   读取.properties配置文件属性
    * */
    @Test
    public void propertiesTest() {
        Properties properties = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(new File("src/main/resources/JDBC.properties"));
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println(user);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void propertiesTest02() throws IOException {
        ClassLoader classLoader = MapTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("JDBC.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user);
        System.out.println(password);

    }

}
