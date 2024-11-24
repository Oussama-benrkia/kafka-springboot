package com.demo.kafkaconsumer.controller;

import com.demo.kafkaconsumer.model.App_User;
import com.demo.kafkaconsumer.repo.UserRepo;
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



    @GetMapping
    public ResponseEntity<List<App_User>> getAllUsers() {
        List<App_User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}