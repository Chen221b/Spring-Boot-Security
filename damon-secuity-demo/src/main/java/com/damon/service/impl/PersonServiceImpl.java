package com.damon.service.impl;

import com.damon.dao.PersonDAO;
import com.damon.dto.Person;
import com.damon.exception.PersonExistException;
import com.damon.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO dao = null;

    @Override
    public Person getPersonByName(String name) {
        List<Person> queryResult = dao.getPersonByName(name);
        switch (queryResult.size()){
            case 0:
                return null;
            case 1:
                return queryResult.get(0);
            default:
                throw new PersonExistException(name);
        }
    }

    @Override
    public String insertPerson(Person p) {
        int opsCode = dao.insertPerson(p);
        if(opsCode == 0) {
            return "Insert operation failed";
        }
        return "Success";
    }

    @Override
    public boolean isPersonExist(String name) {
        List<Person> queryResult = dao.getPersonByName(name);
        if(queryResult.size() > 0){
            return true;
        }else {
            return false;
        }
    }

}
