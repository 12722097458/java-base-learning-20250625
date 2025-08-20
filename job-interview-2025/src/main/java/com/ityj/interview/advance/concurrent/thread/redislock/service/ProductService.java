package com.ityj.interview.advance.concurrent.thread.redislock.service;

public interface ProductService {

    int getBalance(int productId);
    int updateBalance(int productId, int newBalance);

}
