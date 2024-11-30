package com.jitendra.microserviceTwo.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-1",url = "http://localhost:8081/apiOne")
public interface UserController {

    @GetMapping("/getByAge/{age}")
    public ResponseEntity<RecordData> errorThrow(@PathVariable int age);
}
