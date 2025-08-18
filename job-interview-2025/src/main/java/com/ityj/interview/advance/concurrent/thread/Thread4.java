package com.ityj.interview.advance.concurrent.thread;

// 可重入锁
public class Thread4 {

    public static void main(String[] args) {
        methodA();
    }

    public static synchronized void methodA() {
        System.out.println("AAA");
        methodB();
    }


    public static synchronized void methodB() {
        System.out.println("BBB");
    }


    public synchronized void methodB_2() {
        System.out.println("B2");
    }

    // javac Thread4.java
    // javap -v Thread4.class
    public void methodC() {
        synchronized (this) {
            System.out.println("CCC");
        }
    }

}
