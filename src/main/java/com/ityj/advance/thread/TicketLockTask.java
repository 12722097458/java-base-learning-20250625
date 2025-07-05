package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*  ReentrantLock 解决线程安全问题
* */

@Slf4j
public class TicketLockTask implements Runnable {

    public static void main(String[] args) {
        TicketLockTask task = new TicketLockTask();
        new Thread(task, "A").start();
        new Thread(task, "B").start();
        new Thread(task, "C").start();
    }

    private volatile int tickets = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("{} 正在卖票：{}", Thread.currentThread().getName(), tickets--);
                } else {
                    log.info("{} 票卖完了，退出程序...", Thread.currentThread().getName());
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
