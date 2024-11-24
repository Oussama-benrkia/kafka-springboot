package com.demo.kafkaconsumer.consumer;

import com.demo.kafkaconsumer.model.App_User;
import com.demo.kafkaconsumer.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    UserRepo userRepo;
    @KafkaListener(topics = "kfk", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMsg(String msg) throws JsonProcessingException {
        log.info("Received message: {}", msg);
        try {
            App_User user = objectMapper.readValue(msg, App_User.class);
            user.setId(null); // Reset ID to let JPA generate it
            userRepo.save(user);
            log.info("Successfully saved user: {}", user);
        } catch (JsonProcessingException e) {
            log.error("Error deserializing message: {}", msg, e);
            throw e;  // Let the error handler deal with it
        }
    }
}
