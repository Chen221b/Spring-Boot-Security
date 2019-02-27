package com.damon.dto;

import com.damon.validator.PersonNameValid;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.internal.NotNull;

public class Person {

    public interface GetPersonView {};

    @PersonNameValid
    private String name;

    @NotNull
    private String password;

    public Person() {}

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(GetPersonView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
