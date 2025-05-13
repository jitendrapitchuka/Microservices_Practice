package com.jitendra.redis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jitendra.redis.entity.Person;
import com.jitendra.redis.entity.PersonElasticEntity;
import com.jitendra.redis.services.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<PersonElasticEntity>> getPersonById(@PathVariable int id) {
        Optional<PersonElasticEntity> person = personService.getPersonById(id);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.ok().body(savedPerson);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Iterable<PersonElasticEntity>> getAllPerson() {
        Iterable<PersonElasticEntity> persons = personService.getAllPerson();
        return ResponseEntity.ok().body(persons);
    }
    

}
