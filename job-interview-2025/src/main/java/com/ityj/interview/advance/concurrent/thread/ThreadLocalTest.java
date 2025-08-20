package com.ityj.interview.advance.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    static final ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("main");

        new Thread(() -> {
            threadLocal.set("sub thread");
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("inner thread = " + threadLocal.get());
        }).start();
        System.out.println("main thread = " + threadLocal.get());

    }


}
