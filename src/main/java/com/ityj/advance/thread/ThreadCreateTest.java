package com.ityj.advance.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;

public class ThreadCreateTest {
    public static void main(String[] args) {
        // class Thread implements Runnable {
        // 线程创建方法 1
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "......");
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "    ---------   " +  i);
                    /*if (i == 30) {
                        Thread.yield(); //释放当前CPU的执行
                    }*/
                }
            }
        };
        thread.start();
        // thread.start(); Exception in thread "main" java.lang.IllegalThreadStateException
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());


        // 线程创建方法 2
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("Runnable....." + Thread.currentThread().getName());
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "       " +  i + "  " + Thread.currentThread().getPriority());
                    if (i == 66) {
                        thread.join();  // 当前线程进入阻塞状态，直到线程thread执行完成才结束阻塞
                    }
                }
            }
        }).start();

        Callable<Double> callable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return Math.random() * 100;
            }
        };


    }
}
