package com.jitendra.redis.services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.redis.entity.Person;
import com.jitendra.redis.repo.PersonRepo;

@Service
public class PersonService {

@Autowired
private PersonRepo personRepo;

public Optional<Person> getPersonById(int id) {
    return personRepo.findById(id);

}

public Person savePerson(Person person) {
    return personRepo.save(person);
}

public void deletePerson(int id) {
    personRepo.deleteById(id);  
}

public Iterable<Person> getAllPerson() {
    return personRepo.findAll();
}

}
