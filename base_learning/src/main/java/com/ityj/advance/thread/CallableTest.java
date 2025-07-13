package com.ityj.advance.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumberSum implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i + 1;
        }
        return sum;
    }
}
/*
*   Callable 创建线程
*
* */
public class CallableTest {

    public static void main(String[] args) {
        NumberSum numberSum = new NumberSum();
        FutureTask<Integer> futureTask = new FutureTask<>(numberSum);
        new Thread(futureTask).start();

        try {
            Integer result = futureTask.get();
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
