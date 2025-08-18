package com.ityj.interview.advance.concurrent.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// 可见性
public class Thread2 {

    //static volatile boolean flag = false;  //1. 直接volatile
    static boolean flag = false;
    static volatile int count = 1;



    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            check();
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        flag = true;
        System.out.println("main flag = " + flag);

    }

    private static void check_2() {  // 2. synchronized
        while (true) {
            if (flag) {
                System.out.println("flag is true and exit!" + Thread.currentThread().getName());
                break;
            } else {
                System.out.println(111);  // println 带有锁 synchronized (this)
            }
        }
    }

    static ReentrantLock lock  = new ReentrantLock();
    private static void check_3() {  // 3. lock 底层也是cas, 改了volatile state; cpu会把当前所有数据刷到JVM， 包括之前的flag
        while (true) {
            lock.lock();
            if (flag) {
                System.out.println("flag is true and exit!" + Thread.currentThread().getName());
                break;
            } else {
                count++;
            }
            lock.unlock();
        }
    }

    private static void check() {  // 4. 随便找一个volatile修饰的变量，会同时刷新flag
        while (true) {
            if (flag) {
                System.out.println("flag is true and exit!" + Thread.currentThread().getName());
                break;
            } else {
                count++;
            }
        }
    }

}
