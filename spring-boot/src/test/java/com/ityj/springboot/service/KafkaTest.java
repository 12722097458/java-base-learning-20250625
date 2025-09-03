package com.ityj.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Slf4j
@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testOneRecord() {
        String key = "key - "+ System.currentTimeMillis();
        String value = "value - " + System.currentTimeMillis();
        try {
            CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("cloud-topic", key, value);
            future.whenComplete(new BiConsumer<SendResult<String, String>, Throwable>() {
                @Override
                public void accept(SendResult<String, String> result, Throwable e) {
                    if (e == null) {
                        log.info("message send complete!");
                    } else {
                        log.warn("message send failed whenComplete: {} - {}", key, value);
                        log.error("Error is whenComplete ", e);
                        System.out.println("whenComplete 写出数据到数据库，或者直接写出到文件。。。" + key + " - " + value);
                    }
                }
            });
        } catch (Exception e) {
            log.warn("message send failed : {} - {}", key, value);
            log.error("Error is ", e);
            System.out.println("写出数据到数据库，或者直接写出到文件。。。" + key + " - " + value);
        }
    }

    @Test
    public void testProducer() {
        CompletableFuture[] futures = new CompletableFuture[10000];
        for (int i = 0; i < 10000; i++) {
            futures[i] = kafkaTemplate.send("cloud-topic", "kkk" + i, "vvv"  + i);
        }
        CompletableFuture.allOf(futures).join();
        System.out.println("send complete!");
    }

}
