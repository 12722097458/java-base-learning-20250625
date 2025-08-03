package com.ityj.cloud;

import java.time.ZonedDateTime;

public class TestZonedDateTime {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);  // 2025-08-03T07:27:21.328677+08:00[Asia/Shanghai]
    }
}
