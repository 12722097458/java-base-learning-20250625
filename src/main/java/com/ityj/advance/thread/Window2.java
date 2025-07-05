package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

/*
*   同步方法
*
* */
@Slf4j
public class Window2 extends Thread {

    public static void main(String[] args) {
        Window2 window = new Window2("窗口A");
        Window2 window2 = new Window2("窗口B");
        Window2 window3 = new Window2("窗口C");
        window.start();
        window2.start();
        window3.start();
    }

    public static int tickets = 100;

    public Window2() {}
    public Window2(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                log.info("票已经卖完。。。。退出程序");
                break;
            }
            show();

        }
    }

//    private synchronized void show() {   // 错误的，因为当前的锁是this 是new出来的对象有3个window、window2、window3. 不唯一
    private static synchronized void show() { // 正确的， 此时同步监视器是Window2.class
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{} 正在卖票：{}", Thread.currentThread().getName(), tickets--);
        }
    }
}
