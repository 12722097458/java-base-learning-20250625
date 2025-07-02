package com.ityj.base;

import org.junit.jupiter.api.Test;

public class A005_IntergerTest {

    public static void main(String[] args) {

        Integer i1 = new Integer(123);
        Integer i2 = new Integer(123);
        System.out.println(i1 == i2);// false  --  new 的两个不同的对象

        Integer i3 = 222;
        Integer i4 = 222;
        System.out.println(i3 == i4);  // false

        Integer i5 = 11;
        Integer i6 = 11;
        System.out.println(i5 == i6);  // true IntegerCache默认会存储-128 - 127的数。 如果用自动装箱的方式给Integer赋值这个范围内的数。会直接从cache里拿。
    }

    @Test
    public void testValue2() {
        boolean flag = (int) (Math.random()  * 100) % 2 == 1;
        Object o1 = flag ? new Integer(1) : new Double(2.2D);
        System.out.println("o1 = " + o1);  //返回是一个double类型

        /*
        *
        *   编译之后的代码
        *   @Test
            public void testValue2() {
                boolean flag = (int)(Math.random() * 100.0) % 2 == 1;
                Object o1 = flag ? (double)new Integer(1) : new Double(2.2);
                System.out.println("o1 = " + o1);
            }
        * */
    }

    @Test
    public void testBoxed() {
        // 装箱
        Integer in = new Integer(1);
        Integer in2 = Integer.valueOf(1);
        // 自动装箱
        Integer in3 = Integer.parseInt("1");


        //自动拆箱
        int a = in;
        int i = in.intValue();
    }

}
