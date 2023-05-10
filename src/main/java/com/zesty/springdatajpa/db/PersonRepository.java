package com.zesty.springdatajpa.db;

import com.zesty.springdatajpa.api.bean.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findPersonsByFirstName(String firstName);
    List<Person> findPersonsByLastName(String lastName);
    List<Person> findPersonsByAge(Integer age);
}