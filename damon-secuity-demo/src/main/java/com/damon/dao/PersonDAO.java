package com.damon.dao;

import com.damon.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    private JdbcTemplate template;

    public List<Person> listPerson() {
        return null;
    }

    public List<Person> getPersonByName(String name) {
        List<Person> result = template.query(String.format("SELECT * FROM person WHERE name='%s'", name), (ResultSet rs, int rowNum) -> {
            System.out.println(String.format("NO.%d in person", rowNum));
            return new Person(rs.getString("name"), rs.getString("password"));
        });
        return result;
    }

    public int insertPerson(Person p) {
        return template.update(String.format("INSERT INTO person VALUES ('%s','%s')", p.getName(), p.getPassword()));
    }
}
