package com.jitendra.microserviceOne.services;

import com.jitendra.microserviceOne.entity.User;
import com.jitendra.microserviceOne.exception.UserNotFoundException;
import com.jitendra.microserviceOne.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo userRepo;

    public String addToTable(User user){
        userRepo.save(user);
        return "added to table";
    }

    public List<User> getUser(int age) {
        List<User> users =userRepo.findByAge(age);
        if(users.isEmpty()){
            logger.debug("user is empty debug");
            logger.info("user is empty info");
            logger.error("user is empty error");
            logger.warn("user is empty warn");
            logger.trace("user is empty trace");
            throw new UserNotFoundException("user not found with age "+age);
        }
        return users;
    }


}