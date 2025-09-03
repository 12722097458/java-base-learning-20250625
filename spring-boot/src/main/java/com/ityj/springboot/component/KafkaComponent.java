package com.ityj.springboot.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaComponent {

    @KafkaListener(id = "receive1", groupId = "haha", topics = {"cloud-topic"})
    public void receive(ConsumerRecord consumerRecord) {
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        log.info("receive  key :{}, value: {}", key, value);
    }

    @KafkaListener(id = "receive2", groupId = "haha", topics = {"cloud-topic"})
    public void receive2(ConsumerRecord consumerRecord) {
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        log.info("receive2 key :{}, value: {}", key, value);
    }

}
