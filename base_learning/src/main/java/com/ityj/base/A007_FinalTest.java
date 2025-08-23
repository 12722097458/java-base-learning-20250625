package com.ityj.base;

public class A007_FinalTest {
    
    // 成员变量被final修饰， 可直接赋值，可代码块赋值， 可构造方法赋值
    final int A = 1;
    final int B;
    final int C;
    {
        B = 2;
    }

    public A007_FinalTest (int n) {
        C = n;
    }
    
    // 局部变量+final 赋值后不能改变
    public static void main(String[] args) {
        final int num = 3;
//         num = 12; // 编译报错 局部变量一旦赋值不能修改

        final int num2;
        num2 = 3;
//         num2 = 4; // 编译报错  不能修改
        Order order = new Order();
        A007_FinalTest test = new A007_FinalTest(3);
        test.method(order);
        System.out.println("order.id = " + order.id);  // 123
    }
    
    // 形参被final修饰，不能改变
    private void method(final int num) {
//        num = 3; // 编译报错
    }

    // order 不可变，但里面的属性可变
    private void method(final Order order) {
        order.id = 123;
//         order = new Order(); // 编译报错  Cannot assign a value to final variable 'order'
    }

}

class Order {
    public int id;
}

