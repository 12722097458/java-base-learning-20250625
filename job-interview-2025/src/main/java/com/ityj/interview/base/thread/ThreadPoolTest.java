package com.ityj.interview.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        int corePoolSize = 3;
        int maximumPoolSize = 4;
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());
        TimeUnit.SECONDS.sleep(3);
        threadPoolExecutor.execute(new MyTask());

        System.out.println("threadPoolExecutor = " + threadPoolExecutor);
        threadPoolExecutor.shutdown();


    }
}
class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ------------ ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
