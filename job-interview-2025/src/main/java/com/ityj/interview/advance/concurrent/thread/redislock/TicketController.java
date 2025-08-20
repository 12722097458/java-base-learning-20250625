package com.ityj.interview.advance.concurrent.thread.redislock;

import com.ityj.interview.advance.concurrent.thread.redislock.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TicketController {

    @Autowired
    private ProductService productService;

    private static final String REDIS_TEST_LOCK = "REDIS_TEST_LOCK";

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private Redisson redisson;

    @RequestMapping("/sell/{productId}")
    public synchronized String sell(@PathVariable("productId") int productId) throws InterruptedException {

        RLock lock = redisson.getLock(REDIS_TEST_LOCK);
        lock.lock();
        TimeUnit.MINUTES.sleep(3);
        try {
            int balance = productService.getBalance(productId);
            if (balance > 0) {
                int result = productService.updateBalance(productId, balance - 1);
                if (result > 0) {
                    log.info("{} 抢到{}", Thread.currentThread().getName(), balance);
                    return "success";
                } else {
                    log.error("error {} 抢到{}，但数据库更新失败！", Thread.currentThread().getName(), balance);
                }
            }
            return "fail!";
        } finally {
            lock.unlock();
        }
    }
}

