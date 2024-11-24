package com.demo.kafkaproducer.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    // Getters and Setters
    private String key;
    private String msg;

}
