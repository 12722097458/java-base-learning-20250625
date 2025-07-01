package com.ityj.base;

public class A003_StringTest {

    public static void main(String[] args) {
        String str1 = "Jack";   // 存放在StringPool中：堆中
        String str2 = "Rose";
        //str1 = str2;
        swap(str1, str2);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }

    private static void swap(String s1, String s2) {
        s1 = s2;
    }
}
