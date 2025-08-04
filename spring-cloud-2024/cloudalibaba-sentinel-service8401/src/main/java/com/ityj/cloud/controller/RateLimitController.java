package com.ityj.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/rateLimit/byUrl")
    public String byUrl() {
        return "按rest地址限流测试OK";
    }

    @GetMapping("/rateLimit/byResourceSentinel")
    @SentinelResource(value = "byResourceSentinelResource",
            blockHandler = "blockHandlerMethod",
            fallback = "fallbackMethod")
    public String byResource(@RequestParam(value = "p1", required = false) Integer p1) {
        if (p1 != null) {
            int a = 3 / p1;
        }
        return "按rest地址限流测试OK - " + p1;
    }

    public String blockHandlerMethod(@RequestParam(value = "p1", required = false) Integer p1, BlockException e) {
        return "blockHandlerMethod()..." + e.getMessage();
    }

    public String fallbackMethod(@RequestParam(value = "p1", required = false) Integer p1, Throwable t) {
        return "fallbackMethod()... " + t.getMessage();
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }

}

 