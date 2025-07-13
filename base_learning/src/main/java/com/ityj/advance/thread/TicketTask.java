package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

/*
*  Runnable 创建线程
* */

@Slf4j
public class TicketTask implements Runnable {

    public static void main(String[] args) {
        TicketTask task = new TicketTask();
        new Thread(task, "A").start();
        new Thread(task, "B").start();
        new Thread(task, "C").start();
    }

    private volatile int tickets = 100;
    private Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {    // 锁必须唯一  this指的是new 出来的TicketTask对象。 是唯一的TicketTask task = new TicketTask();
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
            }
        }
    }
}
