package com.ityj.base;

import cn.hutool.core.lang.Snowflake;

public class SnowFlakeTest {
    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake();
        long l = snowflake.nextId();  // 1959887397344849920
        System.out.println("l = " + l);
    }
}
