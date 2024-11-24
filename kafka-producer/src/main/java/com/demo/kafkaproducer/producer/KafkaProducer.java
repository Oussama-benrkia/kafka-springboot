package com.demo.kafkaproducer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j

public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String user) {
        log.info("Sending Message: {}", user);
        kafkaTemplate.send("kfk", user);
    }
}
