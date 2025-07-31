package com.ityj.cloud.controller;

import com.ityj.cloud.entities.PayDTO;
import com.ityj.cloud.response.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {


    private static final String PAYMENT_BASE_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_BASE_URL + "/pay/add", payDTO, ResultData.class);
    }

        @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") int id) {
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/pay/get/" + id, ResultData.class);
    }

}
