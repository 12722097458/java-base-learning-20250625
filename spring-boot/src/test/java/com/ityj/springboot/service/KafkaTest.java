package com.ityj.springboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class KafkaTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testOneRecord() {
        CompletableFuture future = kafkaTemplate.send("test-topic", 1,"key", "vvv"  + System.currentTimeMillis());

        future.join();
        System.out.println("send complete!");
    }

    @Test
    public void testProducer() {
        CompletableFuture[] futures = new CompletableFuture[10000];
        for (int i = 0; i < 10000; i++) {
            futures[i] = kafkaTemplate.send("test-topic", "kkk" + i, "vvv"  + i);
        }
        CompletableFuture.allOf(futures).join();
        System.out.println("send complete!");
    }

}
