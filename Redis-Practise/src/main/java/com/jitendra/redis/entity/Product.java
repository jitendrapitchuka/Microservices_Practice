package com.jitendra.redis.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;



@RedisHash(value = "product",timeToLive =25)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {

    @Id
    @Indexed
    private String id=UUID.randomUUID().toString();
    private String name;
    private double price;

    
}
