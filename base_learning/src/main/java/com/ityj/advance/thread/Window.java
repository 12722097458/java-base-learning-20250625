package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;

/*
*   同步代码块
* */
@Slf4j
public class Window extends Thread {

    public static void main(String[] args) {
        Window window = new Window("窗口A");
        Window window2 = new Window("窗口B");
        Window window3 = new Window("窗口C");
        window.start();
        window2.start();
        window3.start();
    }

    public static int tickets = 100;

    public Window () {}
    public Window (String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        while (true) {
            // Window.class 也是对象， 只会加载一次。 所以唯一
            synchronized (Window.class) {   // 不能用this. 不唯一new了3个Window...
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("{} 正在卖票：{}", Thread.currentThread().getName(), tickets--);
                } else {
                    log.info("票已经卖完。。。。退出程序");
                    break;
                }
            }
        }
    }
}
