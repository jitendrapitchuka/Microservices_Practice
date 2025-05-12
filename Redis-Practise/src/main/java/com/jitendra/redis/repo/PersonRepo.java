package com.jitendra.redis.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import com.jitendra.redis.entity.Person;


public interface PersonRepo extends ElasticsearchRepository<Person, Integer> {
    

}
