package com.ityj.interview.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoresPrinter {
    static Semaphore[] semaphores = new Semaphore[3];
    public static void main(String[] args) {
        semaphores[0] = new Semaphore(1);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
        new Thread(new Printer(0)).start();
        new Thread(new Printer(1)).start();
        new Thread(new Printer(2)).start();
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
                    log.info("{} complete2 as index = {}", Thread.currentThread().getName(), index);
                    break;
                }
                Semaphore semaphore = semaphores[id];
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("{} is running......... {} ", Thread.currentThread().getName(), index++);
                if (index >= 100) {
                    log.info("{} complete1 as index = {}", Thread.currentThread().getName(), index);
                    break;
                }
                semaphores[(id + 1) % 3].release(); // 释放下一个线程
            }
        }
    }

}
