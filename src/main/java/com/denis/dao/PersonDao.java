package com.denis.dao;

import com.denis.models.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by denis on 10/17/2015.
 */
@Repository("personDao")
@Transactional
public class PersonDao {


    @PersistenceContext
    private EntityManager entityManager;

    public Person getByName(String name){
        TypedQuery<Person> query = entityManager.createNamedQuery(Person.FIND_BY_NAME_QUERY, Person.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }


    public Person insert(Person person) {
        if (person.getId() == null){
            entityManager.persist(person);
        } else {
            entityManager.merge(person);
        }
        return person;
    }

    @Transactional
    public List<Person> selectAll() {
        TypedQuery<Person> query = entityManager.createNamedQuery(Person.SELECT_ALL_QUERY, Person.class);
        return query.getResultList();

    }

    public long getCount() {
        return (Long) entityManager.createNamedQuery(Person.COUNT_ALL_QUERY).getSingleResult();
    }
}
