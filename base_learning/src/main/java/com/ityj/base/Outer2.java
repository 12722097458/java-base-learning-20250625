package com.ityj.base;

public class Outer2 {
    public static void main(String[] args) {
        // 创建静态内部类，无需外部类实例
        Outer2.StaticNested nested = new Outer2.StaticNested();
        nested.accessFields();

        // 调用静态内部类的静态方法
        Outer2.StaticNested.staticMethod();
    }

    private String instanceField = "Instance Field";
    private static String staticField = "Static Field";

    // 静态内部类
    static class StaticNested {
        public void accessFields() {
            // System.out.println(instanceField); // 错误！不能访问外部类的非静态成员
            System.out.println("访问外部类静态字段: " + staticField); // 可以访问静态成员
            System.out.println("我自己的方法");
        }

        public static void staticMethod() {
            System.out.println("静态内部类的静态方法");
        }
    }

}
