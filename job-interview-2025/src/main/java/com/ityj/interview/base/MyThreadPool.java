package com.ityj.interview.base;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/*
*  线程池回调函数afterExecute可以监测执行状态
*
* */
@Slf4j
public class MyThreadPool extends ThreadPoolExecutor {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(2, 3,
                60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4)
        );

        List<Future> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            try {
                Future future = myThreadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        threadLocal.set(System.nanoTime());
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        log.info("{} 正在执行。。。{}", Thread.currentThread().getName(), threadLocal.get());
                    }
                });
                list.add(future);
            } catch (Exception e) {
                log.info("任务提交失败: {}", i);
            }
        }

    }


    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    // 回调函数
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        log.info("{} 执行完毕。。。{}", Thread.currentThread().getName(), threadLocal.get());
        threadLocal.remove();
    }
}
