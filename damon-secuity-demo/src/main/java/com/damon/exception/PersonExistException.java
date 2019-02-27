package com.damon.exception;

public class PersonExistException extends RuntimeException {

    private String name;

    public PersonExistException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
