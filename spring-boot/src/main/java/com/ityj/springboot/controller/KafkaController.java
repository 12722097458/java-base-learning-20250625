package com.ityj.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Slf4j
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/generate")
    public String generateOneRecord() {
        String key = "k --" + System.currentTimeMillis();
        String value = "value - " + System.currentTimeMillis();
        try {
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("cloud-topic", key, value);
            future.whenComplete(new BiConsumer<SendResult<String, String>, Throwable>() {
                @Override
                public void accept(SendResult<String, String> result, Throwable e) {
                    if (e == null) {
                        log.info("message send complete!");
                    } else {
                        log.warn("message send failed : {} - {}", key, value);
                        log.error("Error is ", e);
                        System.out.println("写出数据到数据库，或者直接写出到文件。。。" + key + " - " + value);
                    }
                }
            });
        } catch (Exception e) {
            log.warn("message send failed : {} - {}", key, value);
            log.error("Error is ", e);
            System.out.println("写出数据到数据库，或者直接写出到文件。。。" + key + " - " + value);
        }
        return value;
    }

}
