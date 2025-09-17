package com.ityj.interview.base;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class SubmitAndExecuteTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // public class ArrayBlockingQueue<E> extends AbstractQueue<E>
        //        implements BlockingQueue<E>, java.io.Serializable {


        // public class LinkedBlockingQueue<E> extends AbstractQueue<E>
        //        implements BlockingQueue<E>, java.io.Serializable {


        /*
        *
        *
        * */
        new ArrayBlockingQueue<>(3);  // capacity 有界队列，必须加入参数   只有一个锁  数租
        new LinkedBlockingQueue<>();  // 默认无界队列。  2个锁takeLock和putLock  单向链表

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(4), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("th-" + System.currentTimeMillis());
                return thread;
            }
        }, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Task());
        }

        /*Future<?> future = threadPoolExecutor.submit(new Task());
        future.get();  // java.util.concurrent.FutureTask.run
        System.out.println("future = " + future);*/


    }


}

class Task implements Runnable {
    @Override
    public void run() {
        //int a = 1 / 0;
        System.out.println(Thread.currentThread().getName() + " is running...");
    }
}
