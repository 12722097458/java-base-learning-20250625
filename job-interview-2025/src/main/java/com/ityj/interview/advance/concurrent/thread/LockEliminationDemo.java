package com.ityj.interview.advance.concurrent.thread;

/*
*   锁消除
* */
public class LockEliminationDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000_000; i++) {
            createStringBuffer("锁消除", "测试");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
    }

    private static String createStringBuffer(String s1, String s2) {
        // StringBuffer内部有synchronized锁
        StringBuffer sb = new StringBuffer();
        sb.append(s1); // 同步操作
        sb.append(s2); // 同步操作
        return sb.toString();
    }
}