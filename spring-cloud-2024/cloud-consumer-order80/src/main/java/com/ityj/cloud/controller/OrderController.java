package com.ityj.cloud.controller;

import com.ityj.cloud.entities.PayDTO;
import com.ityj.cloud.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class OrderController {


    //private static final String PAYMENT_BASE_URL = "http://localhost:8001";
    private static final String PAYMENT_BASE_URL = "http://cloud-payment-service"; //服务注册中心上的微服务名称.

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_BASE_URL + "/pay/add", payDTO, ResultData.class);
    }

    // http://localhost/consumer/pay/get/1
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") int id) {
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/pay/get/" + id, ResultData.class);
    }

    // http://localhost/consumer/pay/info  可以测试负载均衡
    @GetMapping(value = "/consumer/pay/info")
    public ResultData<String> info(){
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/pay/info", ResultData.class);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    // http://localhost/consumer/discovery
    @GetMapping("/consumer/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
