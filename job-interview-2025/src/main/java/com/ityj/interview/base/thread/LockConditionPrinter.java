package com.ityj.interview.base.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionPrinter {
    private static final Lock lock = new ReentrantLock();
    static Condition[] conditions = new Condition[3];
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            conditions[i] = lock.newCondition();
        }
        new Thread(new Printer(0)).start();
        new Thread(new Printer(1)).start();
        new Thread(new Printer(2)).start();
    }

    @Slf4j
    static class Printer implements Runnable {
        private int id;
        static int index = 0;

        public Printer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                if (index >= 100) {
                    log.info("{} complete1 as index = {}", Thread.currentThread().getName(), index);
                    break;
                }
                lock.lock();
                int current = index % 3;
                if (current != id) {
                    try {
                        conditions[id].await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    log.info("{} is running......... {} ", Thread.currentThread().getName(), index++);
                    int next = (id + 1) % 3;
                    conditions[next].signal();
                }
                lock.unlock();
            }
        }
    }

}
