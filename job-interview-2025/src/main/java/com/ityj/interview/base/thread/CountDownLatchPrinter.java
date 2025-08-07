package com.ityj.interview.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatchPrinter {
    static CountDownLatch[] countDownLatches = new CountDownLatch[3];
    public static void main(String[] args) {
        countDownLatches[0] = new CountDownLatch(1);
        countDownLatches[1] = new CountDownLatch(1);
        countDownLatches[2] = new CountDownLatch(1);
        new Thread(new Printer(0)).start();
        new Thread(new Printer(1)).start();
        new Thread(new Printer(2)).start();
        countDownLatches[0].countDown();
    }

    @Slf4j
    static class Printer implements Runnable {
        private  int id;
        public Printer(int id) {
            this.id = id;
        }

        static int index = 0;
        @Override
        public void run() {
            while (true) {
                if (index >= 100) {
                    log.info("{} complete1 as index = {}", Thread.currentThread().getName(), index);
                    break;
                }
                CountDownLatch countDownLatch = countDownLatches[id];
                try {
                    // 1. 阻塞等待机制
                    //countDownLatches[id].await() 会让当前线程阻塞，直到对应的 CountDownLatch 计数器归零
                    //每个线程（0/1/2）都有专属的 CountDownLatch，存储在 countDownLatches 数组中
                    //线程在运行时会先在自己的 CountDownLatch 上等待
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{} is running......... {} ", Thread.currentThread().getName(), index++);
                if (index >= 100) {
                    log.info("{} complete2 as index = {}", Thread.currentThread().getName(), index);
                    break;
                }
                countDownLatches[id] = new CountDownLatch(1);
                countDownLatches[(id + 1) % 3].countDown();
            }
        }
    }

}
