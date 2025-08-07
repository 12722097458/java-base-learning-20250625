package com.ityj.interview.base.thread;

import lombok.extern.slf4j.Slf4j;

public class WaitNotifyPrinter {
    public static void main(String[] args) {
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

                synchronized (Printer.class) {
                    Printer.class.notify();
                    int current = index % 3;
                    if (current != id) {
                        try {
                            Printer.class.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        log.info("{} is running......... {} ", Thread.currentThread().getName(), index++);
                    }
                }
            }
        }
    }

}
