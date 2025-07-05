package com.ityj.advance.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/*
 *   Executors 创建线程
 *
 * */
@Slf4j
public class ExecutorServiceTest {

    public static void main(String[] args) {

        /*
    *     int corePoolSize,                    3
          int maximumPoolSize,                 3
          long keepAliveTime,                  0
          TimeUnit unit,                       MILLISECONDS
          BlockingQueue<Runnable> workQueue,   new LinkedBlockingQueue<Runnable>()  -->  this(Integer.MAX_VALUE);
          ThreadFactory threadFactory,         Executors.defaultThreadFactory()    --> new DefaultThreadFactory()
          RejectedExecutionHandler handler     defaultHandler         -> new AbortPolicy()
    *   创建一个数量固定的线程池，超出的任务会在队列中等待空闲的线程，可用于控制程序的最大并发数。
         */
        //ExecutorService executorService = Executors.newFixedThreadPool(3);



        //CachedThreadPool()：短时间内处理大量工作的线程池，会根据任务数量产生对应的线程，并试图缓存线程以便重复使用，如果限制 60 秒没被使用，则会被移除缓存。
        //          int corePoolSize,                    0
        //          int maximumPoolSize,                 Integer.MAX_VALUE
        //          long keepAliveTime,                  60
        //          TimeUnit unit,                       SECONDS
        //          BlockingQueue<Runnable> workQueue,   new SynchronousQueue<Runnable>()  -->  this(Integer.MAX_VALUE);
        //          ThreadFactory threadFactory,         Executors.defaultThreadFactory()    --> new DefaultThreadFactory()
        //          RejectedExecutionHandler handler     defaultHandler         -> new AbortPolicy()
        //ExecutorService executorService = Executors.newCachedThreadPool();


        // 3 / Integer.MAX_VALUE / 10L / MILLISECONDS / new DelayedWorkQueue() / defaultThreadFactory  / defaultHandler
        //SingleThreadExecutor()：创建一个单线程线程池。
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        //executorService.scheduleWithFixedDelay()
        log.info("start time : {}", new Date());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("{} - 正在执行...{}", Thread.currentThread().getName(), new Date());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService.shutdown();



    }
}
