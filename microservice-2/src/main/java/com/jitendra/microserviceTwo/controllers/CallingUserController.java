package com.jitendra.microserviceTwo.controllers;

import com.jitendra.microserviceTwo.services.UserService;
import com.jitendra.microserviceTwo.utils.RecordData;
import com.jitendra.microserviceTwo.utils.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiTwo")
public class CallingUserController {
    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;

    @GetMapping("/{age}")
    public ResponseEntity<RecordData> getUsersFromFirstService(@PathVariable int age){
        return ResponseEntity.ok().body(new RecordData(userController.errorThrow(age)));
    }

    @GetMapping("/test/{age}")
    public ResponseEntity<RecordData> getUsersFromFirstServices(@PathVariable int age){
        return ResponseEntity.ok().body(new RecordData(userService.getUserByAge(age)));
    }
}
