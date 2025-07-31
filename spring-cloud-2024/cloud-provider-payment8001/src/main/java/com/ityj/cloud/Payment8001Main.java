package com.ityj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;  // 注意 package

@SpringBootApplication
@MapperScan(basePackages = "com.ityj.cloud.mapper")
public class Payment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class, args);
    }
}
