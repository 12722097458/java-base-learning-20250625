package com.ityj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;  // 注意 package

@SpringBootApplication
@MapperScan(basePackages = "com.ityj.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope  // 刷新consul 配置
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
