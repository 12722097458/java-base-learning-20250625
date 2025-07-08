package com.ityj.advance.collection;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 一、Set:存储无序、不可重复的数据
 *  以HashSet为例说明：
 *      1、无序性：不等于随机性。存储的数据在底层数组中并非按照索引添加，而是根据数组的哈希值，按照一定的算法决定。
 *      2、不可重复性：保证添加的方法按照equals()方法判断时，不能返回true.  （hashCode()和equals()）
 *
 *
 */
public class SetTest {

    /**
     * @see HashSet
     * == 底层是HashMap == private transient HashMap<E,Object> map
     *
     */
    @Test
    public void hashSetTest(){
        HashSet<String> set = new HashSet<>();
        boolean add = set.add("111");
        set.add(null);
    }


    /**
     *      LinkedHashSet<E> extends HashSet<E>
     *              super(16, .75f, true);
     *
     *
     */
    @Test
    public void linkedHashSetTest(){
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("s");
    }

    @Test
    public void treeSetTest(){
        Set set = new TreeSet<>();
        set.add("dgd");
        set.add("zdgd");
        //set.add(1);   // 不能添加不同类型的数据 java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer are in module java.base of loader 'bootstrap')
        set.add("dht2");
        //set.add(null); NPE
        set.add("dht2");
        System.out.println("set = " + set);
    }

}
