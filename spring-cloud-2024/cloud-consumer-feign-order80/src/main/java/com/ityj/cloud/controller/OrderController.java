package com.ityj.cloud.controller;

import com.ityj.cloud.apis.PayFeignApi;
import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.response.ResultData;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/pay/add")
    public ResultData addOrder(Pay pay) {
        return payFeignApi.addPay(pay);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") int id) {
        return payFeignApi.queryById(id);
    }

    @GetMapping("/feign/pay/getAll")
    public ResultData getAll() {
        return payFeignApi.queryAll();
    }

    // http://localhost/feign/pay/info
    @GetMapping(value = "/feign/pay/info")
    public ResultData<String> info(){
        return payFeignApi.info();
    }

    // http://localhost:80/feign/pay/consul/config
    @GetMapping(value = "/feign/pay/consul/config")
    public ResultData<String> listConfig(){
        return payFeignApi.listConfig();
    }

    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRatelimitFallback")
    public String ratelimit(@PathVariable("id") Integer id) {
        return payFeignApi.myRatelimit(id);
    }

    public String myRatelimitFallback(Integer id,Throwable t) {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }


}
