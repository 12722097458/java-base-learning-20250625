package com.ityj.base;

public class Outer3 {

    public static void main(String[] args) {
        Outer3 outer = new Outer3();
        outer.someMethod();
        // 无法在 someMethod() 外部创建 LocalInner 对象
    }

    private String outerField = "Outer Field";

    public void someMethod() {
        final String localVar = "Local Variable"; // final 局部变量
        String effectivelyFinalVar = "Effectively Final"; // effectively final

        // 局部内部类
        class LocalInner {
            public void print() {
                System.out.println(outerField); // 访问外部类成员
                System.out.println(localVar);   // 可以访问 final 局部变量
                System.out.println(effectivelyFinalVar); // 可以访问 effectively final 变量
            }
        }

        // 在方法内部创建并使用局部内部类
        LocalInner localInner = new LocalInner();
        localInner.print();
    }

}
