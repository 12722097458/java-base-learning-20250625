package com.ityj.interview.base;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABASolution {
    public static void main(String[] args) {
        // 初始值：100，初始版本号：0
        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(100, 0);

        int initialStamp = asr.getStamp(); // 获取初始版本号

        // 线程1尝试修改，但会休眠一下
        new Thread(() -> {
            try {
                Thread.sleep(1000); // 休眠，让线程2有机会执行ABA操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean success = asr.compareAndSet(100, 101, initialStamp, initialStamp + 1);
            System.out.println("线程1 CAS 操作结果: " + success); // 输出 false，因为版本号变了
        }).start();

        // 线程2执行ABA操作
        new Thread(() -> {
            // 第一次修改： 100 -> 101，版本号 0 -> 1
            asr.compareAndSet(100, 101, asr.getStamp(), asr.getStamp() + 1);
            System.out.println("线程2第一次修改: [值=" + asr.getReference() + ", Stamp=" + asr.getStamp() + "]");

            // 第二次修改： 101 -> 100，版本号 1 -> 2
            asr.compareAndSet(101, 100, asr.getStamp(), asr.getStamp() + 1);
            System.out.println("线程2第二次修改: [值=" + asr.getReference() + ", Stamp=" + asr.getStamp() + "]");
        }).start();
    }
}
