package com.ityj.interview.advance.concurrent.thread.redislock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TicketController {

    private int count = 100;

    @RequestMapping("/sell")
    public String sell() throws InterruptedException {
        if (count > 0) {
            TimeUnit.MILLISECONDS.sleep(10);
            log.info("{} 正在出售id为{}的票", Thread.currentThread().getName(), count--);
        }
        return "success";
    }
}

