package com.ityj.base;

// 定义一个接口
interface Greeting {
    void sayHello();
}

public class Outer4 {
    public void createAnonymousClass() {
        String message = "Hello"; // effectively final

        // 创建并实现一个接口（匿名内部类）
        Greeting greeting = new Greeting() { // 注意这里的 new 关键字
            @Override
            public void sayHello() {
                System.out.println(message + ", World!"); // 访问 effectively final 变量
                System.out.println("我是匿名内部类");
            }
        };

        greeting.sayHello();

        // 更常见的用法：直接作为参数传递
        someMethodThatNeedsGreeting(new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("直接传入的匿名内部类");
            }
        });
    }

    private void someMethodThatNeedsGreeting(Greeting g) {
        g.sayHello();
    }

    public static void main(String[] args) {
        new Outer4().createAnonymousClass();
    }
}
