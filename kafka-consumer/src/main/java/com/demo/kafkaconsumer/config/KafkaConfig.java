package com.demo.kafkaconsumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("kfk")
                .partitions(2).build();
    }

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }


}