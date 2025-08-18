package com.ityj.interview.advance.concurrent.thread;

// 原子性可以解决并发编程问题
// count = 168  可以用 cas/ synchronized /  lock 解决
public class Thread1 {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            incr();
        });
        Thread t2 = new Thread(() -> {
            incr();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);

    }

    private static synchronized void incr() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }

}
