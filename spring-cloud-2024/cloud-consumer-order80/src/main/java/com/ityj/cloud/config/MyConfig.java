package com.ityj.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced // 默认轮询RoundRobinLoadBalancer 开启默认的负载均衡  - 本地端    nginx是服务器端
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
