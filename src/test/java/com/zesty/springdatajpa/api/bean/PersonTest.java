package com.zesty.springdatajpa.api.bean;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.zesty.springdatajpa.TestUtils.AssertionsExtended.verifyToString;
import static com.zesty.springdatajpa.TestUtils.AssertionsExtended.verifyEqualsAndHashCode;
import static com.zesty.springdatajpa.TestUtils.AssertionsExtended.verifySerdes;

public class PersonTest {

    protected static Person createPerson() {
        return new Person("John", "Doe", 25);
    }

    @Test @DisplayName("getter")
    void getter() {
        val person = createPerson();
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(25, person.getAge());
    }

    @Test @DisplayName("setter")
    void setter() {
        val person = new Person();
        person.setFirstName("Timmy");
        person.setLastName("Turner");
        person.setAge(32);
        assertEquals("Timmy", person.getFirstName());
        assertEquals("Turner", person.getLastName());
        assertEquals(32, person.getAge());
    }

    @Test @DisplayName("toString")
    void string() {
        verifyToString("Person(id=null, firstName=John, lastName=Doe, age=25)", createPerson());
    }

    @Test @DisplayName("equals and hash")
    void equalsAndHash() {
        verifyEqualsAndHashCode(createPerson(), createPerson());
    }

    @Test @DisplayName("serdes")
    void serdes() throws IOException {
        verifySerdes(createPerson(),
            "{\"id\":null,\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":25}");
    }

}