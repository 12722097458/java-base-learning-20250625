package com.ityj.advance.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 *  List : 有序、可重复  '动态'数组：长度不固定(jdk1.2)
 *      ArrayList：List的主要实现类(jdk1.2) ,线程不安全，效率高;低层使用数组Object[] elementData 存储
 *      LinkedList：(jdk1.2) 底层使用的是双向链表：对频繁的插入以及删除操作效率较高。
 *      Vector：最早的实现类（JDK1.0）  线性安全、效率低，低层使用数组Object[] elementData 存储
 *
 *      同：三个类都实现了List接口，存储数据的特点相同：有序，可重复
 */

public class ListTest {
    public static void main(String[] args) {

        int num = 3;

        int num2 = num >> 1;

        System.out.println("num2 = " + num2);
    }

    /**
     * ArrayList源码解析：
     * ==底层是数组==
     jdk1.7和1.8是不同的。
     jdk1.7：初始化的时候默认创建的集合长度是 10的Object[]
     1.7的扩容是1.5倍进行的：int newCapacity = oldCapacity + (oldCapacity >> 1);


     jdk1.8: 初始化时默认没有创建数组，节省内存：private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     第一次调用add()方法时，会进行默认初始化长度为10的数组、
     后续和1.7一致

     总结：jdk7的ArrayList创建类似于单例中的饿汉式，而jdk8中的ArrayList创建类似于懒汉式。
     */
    @Test
    public void arrayListTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");   // 第11次调用需要扩容   10 -->  15
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16"); // 第16次进行扩容   15 --> 22
        list.add("17");
        list.add("18");
        list.add("19");
        list.add(null);

        System.out.println(list.size());
        System.out.println(list);
    }

    /**
     *      ==底层双向链表==
     *   内部声明了Node的first 和 last属性，默认值都是null
     *   进行新增：list.add(123);   将123封装到Node中，创建了Node对象
     *
     *      可以体现LinkedList的双向链表结构
     *
     *private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
         }
      }
     */
    @Test
    public void linkedListTest() {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");
    }


    /**
     *  ==底层是：数组== protected Object[] elementData
     *  初始化长度10，扩容方式也不太一样，2倍扩容
     *  同步，线性安全。很少使用      public synchronized boolean add(E e) {}
     */
    @Test
    public void vectorTest() {
        Vector list = new Vector();
        list.add(1);
    }
}
