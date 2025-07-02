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

