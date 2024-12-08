package com.jitendra.microserviceOne.controllers;

import com.jitendra.microserviceOne.entity.User;
import com.jitendra.microserviceOne.services.UserService;
import com.jitendra.microserviceOne.utils.RecordData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getByAge/{age}")
    public ResponseEntity<RecordData> errorThrow(@PathVariable int age){
        List<User> users=userService.getUser(age);
        return ResponseEntity.status(200).body(new RecordData(users));
    }

    @PostMapping("/add")
    public ResponseEntity<RecordData> addToTable(@RequestBody User user){
        String s=userService.addToTable(user);
        return ResponseEntity.ok().body(new RecordData(s));
    }
}