package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketTask implements Runnable {

    public static void main(String[] args) {
        TicketTask task = new TicketTask();
        new Thread(task, "A").start();
        new Thread(task, "B").start();
        new Thread(task, "C").start();
    }

    private volatile int tickets = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("{} 正在卖票：{}", Thread.currentThread().getName(), tickets--);
                } else {
                    log.info("{} 票卖完了", Thread.currentThread().getName());
                    break;
                }
            }
        }
    }
}
