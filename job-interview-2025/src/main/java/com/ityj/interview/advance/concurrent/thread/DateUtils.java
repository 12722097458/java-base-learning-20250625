package com.ityj.interview.advance.concurrent.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    // static: 确保整个JVM中只有一个 threadLocalDateFormat 实例作为Key
    private static final ThreadLocal<SimpleDateFormat> threadLocalDateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static String format(Date date) {
        // 每个线程调用 get() 时，获取的是自己线程的 SimpleDateFormat 副本
        return threadLocalDateFormat.get().format(date);
    }
    
    public static void cleanup() {
        // 清理当前线程的value
        threadLocalDateFormat.remove();
    }
}