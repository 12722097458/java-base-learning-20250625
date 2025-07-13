package com.ityj.base;

public class A006_SingletonTest {


}

class Hungry {

    private static final Hungry INSTANCE = new Hungry();
    private Hungry() {};

    public static Hungry getInstance() {
        return INSTANCE;
    }

}

class Lazy {

    private static volatile Lazy INSTANCE;
    private Lazy() {};

    // 效率差。。 其实只有第一次会出现现成问题
    public synchronized static Lazy getInstance2() {// 锁的是Lazy.class
        if (INSTANCE == null) {
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }
    public static Lazy getInstance2_2() {
        synchronized (Lazy.class) {
            if (INSTANCE == null) {
                INSTANCE = new Lazy();
            }
            return INSTANCE;
        }
    }


    // 双重校验锁  效率更高
    public static Lazy getInstance() {
        if (INSTANCE == null) {
            synchronized (Lazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Lazy();
                }
            }
        }
        return INSTANCE;
    }
}

