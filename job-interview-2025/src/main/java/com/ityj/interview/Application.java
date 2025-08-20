package com.ityj.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ityj.interview.advance.concurrent.thread.redislock.mapper") // 导入包下的所有mapper
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
