package com.damon.service;

import com.damon.dto.Person;

public interface PersonService {
    public Person getPersonByName(String name);

    public String insertPerson(Person p);

    public boolean isPersonExist(String name);
}
