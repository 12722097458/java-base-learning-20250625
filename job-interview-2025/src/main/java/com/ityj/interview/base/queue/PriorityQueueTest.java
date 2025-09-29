package com.ityj.interview.base.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {


    /*
    *
    *   给出N个正整数ai(1<=i<=n)支持两种操作（可选择任意操作）：
        1） 删除两个相同的数，添加这两个数之和
        2）删除两个数，添加这两个数中的最大值
        已知通过n-1次操作后，只剩下一个数，求这个数的最大值
    *
    * */
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("queue = " + queue);
        while (true) {
            if (!queue.isEmpty() && queue.size() > 1) {
                int first = queue.poll();
                int second = queue.poll();
                if (first == second) {
                    queue.add(first + second);
                } else {
                    queue.add(Math.max(first, second));
                }
            } else {
                break;
            }
        }
        System.out.println(queue.peek());
    }

}
