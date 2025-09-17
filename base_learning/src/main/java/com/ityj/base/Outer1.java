package com.ityj.base;

public class Outer1 {
    public static void main(String[] args) {
        // 1. 创建外部类对象
        Outer1 outer = new Outer1();
        // 2. 通过外部类对象创建内部类对象
        Outer1.Inner inner = outer.new Inner();
        inner.accessOuter();

        // 或者调用外部类的方法，在内部创建
        outer.createInner();
    }


    private String outerField = "Outer Field";

    // 成员内部类
    public class Inner {
        private String innerField = "Inner Field";

        public void accessOuter() {
            // 内部类可以直接访问外部类的私有成员
            System.out.println("访问外部类字段: " + outerField);
            // 也可以使用 Outer.this 来显式指定
            System.out.println("显式访问: " + Outer1.this.outerField);
        }
    }

    public void createInner() {
        // 在外部类内部，可以直接创建内部类对象
        Inner inner = new Inner();
        inner.accessOuter();
    }


}
