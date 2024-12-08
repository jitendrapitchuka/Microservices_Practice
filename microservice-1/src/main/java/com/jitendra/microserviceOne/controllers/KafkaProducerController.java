package com.jitendra.microserviceOne.controllers;

import com.jitendra.microserviceOne.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendMessage/{msg}")
    public ResponseEntity<String> sendMessage(@PathVariable String msg){
        kafkaProducerService.sendMessage(msg);
        return ResponseEntity.ok().body("message sent");
    }
}
