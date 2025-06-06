package com.jitendra.redis.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.jitendra.redis.entity.Product;

@Configuration
public class RedisConfig {

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        
        RedisCacheConfiguration cacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMillis(25000))
        .serializeValuesWith(RedisSerializationContext.SerializationPair
        .fromSerializer(new Jackson2JsonRedisSerializer<>(Product.class)));

        
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration).build();

    }

}
