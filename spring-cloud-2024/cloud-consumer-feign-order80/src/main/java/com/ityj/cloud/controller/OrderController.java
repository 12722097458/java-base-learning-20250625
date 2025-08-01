package com.ityj.cloud.controller;

import com.ityj.cloud.apis.PayFeignApi;
import com.ityj.cloud.entities.Pay;
import com.ityj.cloud.response.ResultData;
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

    @GetMapping(value = "/feign/pay/info")
    public ResultData<String> info(){
        return payFeignApi.info();
    }
}
