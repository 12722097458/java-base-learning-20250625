package com.ityj.interview.advance.concurrent.thread;

import org.openjdk.jol.info.ClassLayout;

public class MarkWordTest {
    // 无锁
    public static void A() {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());  // 01 00 00 00 (00000001 00000000 00000000 00000000) (1)
    }

    //  通过参数-XX:+UnlockDiagnosticVMOptions  -XX:+UseBiasedLocking 开启偏向锁
    public static void B() throws InterruptedException {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());  // 05 00 00 00 (00000101 00000000 00000000 00000000) (5)
    }

    // 轻量级锁
    public static void C() throws InterruptedException {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " : " + ClassLayout.parseInstance(obj).toPrintable());
            }
        });

        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " : " + ClassLayout.parseInstance(obj).toPrintable());
            t1.start();
            Thread.sleep(3000);
        }
        t1.join();

        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName() + " : " + ClassLayout.parseInstance(obj).toPrintable());
    }
}
