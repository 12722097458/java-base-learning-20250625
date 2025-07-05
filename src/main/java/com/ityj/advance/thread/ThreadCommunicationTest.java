package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Clerk {

    private int count = 0;

    public void consume() {
        while (true) {
            synchronized (this) {
                if (count > 0) {
                    this.notifyAll();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("消费者:{} 消费了产品:{}", Thread.currentThread().getName(), count--);
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }

    public void produce() {
        while (true) {
            synchronized (this) {
                if (count < 20) {
                    this.notifyAll();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("生产者:{} 生产了产品:{}", Thread.currentThread().getName(), ++count);
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

@Slf4j
class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        log.info("Producer .... ");
        clerk.produce();
    }
}

@Slf4j
class Consumer implements Runnable {
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    private Clerk clerk;

    @Override
    public void run() {
        log.info("Consumer .... ");
        clerk.consume();
    }
}


@Slf4j
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Consumer(clerk)).start();
        new Thread(new Producer(clerk)).start();
    }
}
