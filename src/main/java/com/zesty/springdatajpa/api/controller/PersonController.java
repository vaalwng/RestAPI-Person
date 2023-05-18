package com.zesty.springdatajpa.api.controller;

import com.zesty.springdatajpa.api.bean.Person;
import com.zesty.springdatajpa.api.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @Slf4j
@RequestMapping(path = "/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    // sample: http://localhost:7777/zesty/api/person/create?firstName=John&lastName=Doe&age=35
    @PostMapping(value = "/create")
    public ResponseEntity<Person> createPerson(@RequestParam(value = "firstName") final String firstName,
                               @RequestParam(value = "lastName") final String lastName,
                               @RequestParam(value = "age") final int age) {
        val person = personService.createPerson(firstName, lastName, age);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // sample: http://localhost:7777/zesty/api/person/delete?id=1
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deletePerson(@RequestParam(value = "id") final Long id) {
        val result = personService.deletePerson(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // sample: http://localhost:7777/zesty/api/person/getall
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

}