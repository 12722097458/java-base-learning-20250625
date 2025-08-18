package com.ityj.interview.advance.concurrent.thread;

// 有序性
public class Thread3 {

    static int a,b,x,y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;


            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (x == 0 && y == 0) {
                System.out.println("i == " + i + " 时，x == " + x + ", y == " + y);
            }

        }

        System.out.println("main complete... ");

    }



}

class Lazy {

    private Lazy() {}

    private static Lazy INSTANCE = null;

    public static Lazy getInstance() {
        if (INSTANCE == null) {
            synchronized (Lazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Lazy();  // 可能出现指令重排。 正常 1申请空间  2初始化  3变量引用。   如果 132 就会导致对象未初始化 t2判断非空，返回的对象是不完整的
                }
            }
        }
        return INSTANCE;
    }


}
