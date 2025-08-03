package com.ityj.cloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {

    // 需要用响应式编程来处理
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        long start = System.currentTimeMillis();
        log.info("start ");
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
            log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
            log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
            log.info("访问接口URL参数: " + exchange.getRequest().getURI().getRawQuery());
            log.info("访问接口时长: " + (System.currentTimeMillis() - start) + "ms");
            System.out.println();
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}