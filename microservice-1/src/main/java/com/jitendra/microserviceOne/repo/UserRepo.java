package com.jitendra.microserviceOne.repo;

import com.jitendra.microserviceOne.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    public List<User> findByAge(int age);
}
