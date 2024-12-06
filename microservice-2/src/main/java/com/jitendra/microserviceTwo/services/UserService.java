package com.jitendra.microserviceTwo.services;

import com.jitendra.microserviceTwo.utils.RecordData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class UserService {

    private Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired
    private RestTemplate restTemplate;

@CircuitBreaker(name="userControllerCircuitBreaker",fallbackMethod = "fallBackForGetUserByAge")
    public RecordData getUserByAge(int age){
        String Url="http://localhost:8081/apiOne/getByAge/"+age;
        ResponseEntity<RecordData>response=restTemplate.getForEntity(Url,RecordData.class);
        return response.getBody();
    }

    public RecordData fallBackForGetUserByAge(int age,Throwable ex){
    logger.info(ex.getMessage());
    return new RecordData("circuit breakers working");
    }
}
