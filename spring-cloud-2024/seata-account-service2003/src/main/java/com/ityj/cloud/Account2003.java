package com.ityj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.ityj.cloud.mapper")
public class Account2003 {

    public static void main(String[] args) {
        SpringApplication.run(Account2003.class, args);
    }

}
