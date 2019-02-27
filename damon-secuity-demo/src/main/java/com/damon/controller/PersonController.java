package com.damon.controller;

import com.damon.dto.Person;
import com.damon.service.impl.PersonServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl service = null;

    @GetMapping("/{name:\\w+}")
    @JsonView(Person.GetPersonView.class)
    public Person getPerson(@PathVariable String name) {
        return service.getPersonByName(name);
    }

    @PostMapping
    public String insertPerson(@Valid @RequestBody Person p, BindingResult error) {
        if(error.hasErrors()) {
            System.out.println(error.getRawFieldValue("name"));
        }
        return service.insertPerson(p);
    }
}
