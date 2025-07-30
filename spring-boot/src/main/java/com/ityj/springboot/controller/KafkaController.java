package com.ityj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/generate")
    public String generateOneRecord() {
        String key = "generateOneRecord";
        String value = "value - " + System.currentTimeMillis();
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("test-topic", key, value);
        send.join();
        return value;
    }

}
