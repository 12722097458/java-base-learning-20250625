package com.ityj.interview.advance.concurrent.thread;



import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class Cas {


    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //   public final native boolean compareAndSetInt(Object o, long offset,
    //                                                 int expected,
    //                                                 int x);
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Unsafe unsafe = reflectGetUnsafe();
        long offset = unsafe.objectFieldOffset(Cas.class.getDeclaredField("count"));
        System.out.println("offset = " + offset);  // Cas对象 头 + count  头有12字节，count4字节。 所以count的offset是12
        Cas cas = new Cas();
        cas.setCount(0);
        unsafe.compareAndSwapInt(cas, offset, 0, 100);
        System.out.println("cas.getCount() = " + cas.getCount());
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Class<?> name = Class.forName("sun.misc.Unsafe");
            Field field = name.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
