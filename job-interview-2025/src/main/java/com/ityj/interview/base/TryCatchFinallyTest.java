package com.ityj.interview.base;

public class TryCatchFinallyTest {
    public static void main(String[] args) {
//        System.out.println(print1()); // 34
        System.out.println(try_catch_finally());
    }


    private static int print1() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.print(3);
            return 4;   // finally中的return会覆盖try中的return
        }
    }

    public static String try_catch_finally() {
        String string = "return_value_1";
        try {
            return string;
        } finally {
            string = "return_value_2";
            return string;
        }
    }
}
