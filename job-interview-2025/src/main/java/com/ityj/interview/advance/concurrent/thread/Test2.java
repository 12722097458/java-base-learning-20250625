package com.ityj.interview.advance.concurrent.thread;

import java.io.IOException;
import java.util.concurrent.*;

public class Test2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        // 必须设置队列的长度
        ArrayBlockingQueue queue = new ArrayBlockingQueue(4);
        // 生产者扔数据
        queue.add("1");
        queue.offer("2");
        queue.offer("3",2, TimeUnit.SECONDS);
        queue.put("2");

        // 消费者
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2,TimeUnit.SECONDS));
        System.out.println(queue.take());

        new LinkedBlockingQueue<>();
        new LinkedBlockingDeque<>();

        Executors.newFixedThreadPool(4);   // LinkedBlockingQueue(Integer.MAX)
        Executors.newSingleThreadExecutor();   // LinkedBlockingQueue(Integer.MAX)
        Executors.newCachedThreadPool();   // core=0, maximumPoolSize=MAX , new SynchronousQueue();
        Executors.newScheduledThreadPool(4);   // maximumPoolSize=Integer.MAX_VALUE

    }
}
