package com.denis.services;

import com.denis.dao.PersonDao;
import com.denis.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by denis on 10/17/2015.
 */
@Service
public class PersonService {
    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }
    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addPerson(Person person) {
        getPersonDao().insert(person);
    }

    public List<Person> fetchAllPersons() {
        return getPersonDao().selectAll();
    }

    public Person findByName(String name){
        return personDao.getByName(name);
    }

    public long getCount(){
        return personDao.getCount();
    }
}
