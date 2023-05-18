package com.zesty.springdatajpa.api.services;

import com.zesty.springdatajpa.api.bean.Person;
import com.zesty.springdatajpa.api.exception.PersonNotFoundException;
import com.zesty.springdatajpa.db.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @Slf4j
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<Person>();
        try {
            personRepository.findAll().forEach(personList::add);
            return personList;
        } catch (Exception e) {
            return null;
        }
    }

    public Person createPerson(final String firstName, final String lastName, final Integer age) {
        try {
            val person = personRepository.save(new Person(firstName, lastName, age));
            log.info("SUCCESSFUL creation of Person({}, {}, {}, {})", person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
            return person;
        } catch (Exception e) {
            log.info("FAILED creation of Person({}, {}, {})", firstName, lastName, age);
            return null;
        }
    }

    public String deletePerson(final Long id) {
        if(!personRepository.existsById(id)) {
            throw new PersonNotFoundException(id);
        }
        personRepository.deleteById(id);
        log.info("User (ID: {}) has been deleted", id);
        return String.format("User (ID: %s) has been deleted", id);
    }

}
