package com.ityj.interview.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 三个线程交替按顺序执行
public class FairSyncLock {
    public static void main(String[] args) {
        // 1 new ReentrantLock(true);
        Runnable r = new Task1();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }

}

@Slf4j
class Task1 implements Runnable {
    private final Lock lock = new ReentrantLock(true);
    volatile int index = 0;
    @Override
    public void run() {
        while (true) {
            if (index >= 100) {
                log.info("{} complete1 as index = {}", Thread.currentThread().getName(), index);
                break;
            }
            lock.lock();
            if (index >= 100) {
                log.info("{} complete2 as index = {}", Thread.currentThread().getName(), index);
                break;
            }
            log.info("{} is running......... {} ", Thread.currentThread().getName(), index++);
            lock.unlock();
        }
    }
}


