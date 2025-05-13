package com.jitendra.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jitendra.redis.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    
   

}
