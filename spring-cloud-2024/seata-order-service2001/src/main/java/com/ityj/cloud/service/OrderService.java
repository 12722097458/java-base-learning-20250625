package com.ityj.cloud.service;

import com.ityj.cloud.entities.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}