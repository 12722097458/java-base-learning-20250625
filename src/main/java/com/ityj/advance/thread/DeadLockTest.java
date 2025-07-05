package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLockTest {

    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("a");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s2) {
                        s1.append("b");
                        s2.append("b");
                        System.out.println("s1 = " + s1);
                        System.out.println("s2 = " + s2);
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("6");
                    s2.append("6");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (s1) {
                        s1.append("8");
                        s2.append("8");
                        System.out.println("s1 = " + s1);
                        System.out.println("s2 = " + s2);
                    }
                }

            }
        }).start();
    }
}
