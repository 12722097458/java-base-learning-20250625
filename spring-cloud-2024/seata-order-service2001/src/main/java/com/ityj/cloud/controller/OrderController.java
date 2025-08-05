package com.ityj.cloud.controller;

import com.ityj.cloud.entities.Order;
import com.ityj.cloud.response.ResultData;
import com.ityj.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}