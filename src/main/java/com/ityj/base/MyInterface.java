package com.ityj.base;

public interface MyInterface extends MyInterface2, MyInterface3 {

    // 常量
    public static final double PI = 3.14D;

    // 抽象方法，abstract可省略
    void invoke();
    abstract int getData();

    // 静态方法
    static void method() {
        System.out.println("MyInterface.static method...");
    }
    // 默认方法
    default void method2() {}

    @Override
    default void t() {

    }

    @Override
    default void d() {
        MyInterface2.super.d();
    }
}

class Clazz implements MyInterface3, MyInterface2 {

    @Override
    public void t() {

    }

    // 两个接口都有default的同名方法，必须在子类中重写
    // com. ityj. base. Clazz inherits unrelated defaults for d() from types com. ityj. base. MyInterface3 and com. ityj. base. MyInterface2
    @Override
    public void d() {

    }
}
