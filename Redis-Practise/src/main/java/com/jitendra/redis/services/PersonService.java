package com.jitendra.redis.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitendra.redis.entity.Person;
import com.jitendra.redis.entity.PersonElasticEntity;
import com.jitendra.redis.repo.PersonElasticRepo;
import com.jitendra.redis.repo.PersonRepo;


@Service
public class PersonService {

@Autowired
private PersonRepo personRepo;
@Autowired
private PersonElasticRepo personElasticRepo;

public Optional<PersonElasticEntity> getPersonById(int id) {
    return personElasticRepo.findById(id);

}

public Person savePerson(Person person) {
    PersonElasticEntity personElasticEntity =new PersonElasticEntity();
    Person savedPerson = personRepo.save(person);
    personElasticEntity.setId(savedPerson.getId());
    personElasticEntity.setName(savedPerson.getName());
    personElasticEntity.setEmail(savedPerson.getEmail());
    personElasticRepo.save(personElasticEntity);

    return savedPerson;
    
}

public void deletePerson(int id) {
    personRepo.deleteById(id);
    personElasticRepo.deleteById(id);  
}

public Iterable<PersonElasticEntity> getAllPerson() {
    return personElasticRepo.findAll();
}

}
