package com.denis.repos;

import com.denis.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by denis on 10/18/2015.
 */
@Repository("personRepo")
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    Person findByName(String name);
}
