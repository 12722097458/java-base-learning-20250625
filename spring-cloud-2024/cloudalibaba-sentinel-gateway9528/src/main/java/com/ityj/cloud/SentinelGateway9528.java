package com.ityj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelGateway9528 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelGateway9528.class, args);
    }
}
