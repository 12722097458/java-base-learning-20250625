package com.ityj.interview.advance.concurrent.thread.redislock.service.impl;

import com.ityj.interview.advance.concurrent.thread.redislock.mapper.ProductMapper;
import com.ityj.interview.advance.concurrent.thread.redislock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int getBalance(int productId) {
        return productMapper.getBalance(productId);
    }

    @Override
    public int updateBalance(int productId, int newBalance) {
        return productMapper.updateBalance(productId, newBalance);
    }
}
