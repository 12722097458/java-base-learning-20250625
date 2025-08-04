package com.ityj.cloud.controller;

import com.ityj.cloud.apis.PayFeignSentinelApi;
import com.ityj.cloud.response.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PayFeignSentinelApi payFeignSentinelApi;

    private static final String PAYMENT_BASE_URL = "http://nacos-payment-provider"; //服务注册中心上的微服务名称.

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(PAYMENT_BASE_URL + "/pay/nacos/" + id, String.class);
        return result + "\t" + "    我是OrderNacosController调用者。。。。。。";
    }

    @GetMapping(value = "/consumer/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo) {
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }
}

