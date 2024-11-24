package com.demo.kafkaproducer.controller;

import com.demo.kafkaproducer.model.App_User;
import com.demo.kafkaproducer.producer.KafkaProducer;
import com.demo.kafkaproducer.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepo userService;
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<App_User> createUser( @RequestBody App_User user) throws JsonProcessingException {
        App_User createdUser = userService.save(user);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json=ow.writeValueAsString(user);
        kafkaProducer.send(json);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<App_User>> getAllUsers() {
        List<App_User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}