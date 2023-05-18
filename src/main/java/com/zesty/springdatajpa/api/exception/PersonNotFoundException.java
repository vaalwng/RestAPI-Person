package com.zesty.springdatajpa.api.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Could not find the user with id: " + id);
    }
}
