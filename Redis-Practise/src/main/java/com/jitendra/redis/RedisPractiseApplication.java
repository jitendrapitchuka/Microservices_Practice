package com.jitendra.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisPractiseApplication.class, args);
	}

}
