package com.ityj.base;

public class A009_InnerClassTest {

    public static void main(String[] args) {
        float f = 123.4F;
        float f2 = (float) 123.4; // 浮点型常熟默认类型是double,所以需要加F。或强转(float) 123.4
        short s = 123;  // 字面量123的默认类型是int， 对于整数，如果该范围在目标范围内，会自动执行隐式类型转换。所以没有编译报错

        char c = 'a';
        byte b = 3;
        int s2 = s + s;
        int s3 = s + b;
        int s4 = c + s;  // byte/short/char 之间的运算都要用int接收

        s+=3;
        s++;   // s+=  s++ 都不会改变本身的数据类型

        int a2 = 0B0011;  // 二进制binary   0B或0开头    3
        int a10 = 123;  // 十进制 decimal               123
        int a8 = 027;  // 八进制octal  0开头              23
        int a16 = 0x11; // 十六进制 hex  0x或0X开头       17

        int res1 = 12 % 5;     // 2 结果的符号与被模数一致
        int res2 = 12 % -5;    // 2
        int res3 = -12 % 5;    // -2
        int res4 = -12 % -5;   // -2
    }
}
