package com.ityj.interview.advance.concurrent.thread.redislock;

import com.ityj.interview.advance.concurrent.thread.redislock.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TicketController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/sell/{productId}")
    public synchronized String sell(@PathVariable("productId") int productId) {
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
    }
}

