package com.jitendra.redis.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jitendra.redis.entity.PersonElasticEntity;


public interface PersonElasticRepo extends ElasticsearchRepository<PersonElasticEntity,Integer> {
    

}
