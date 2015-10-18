package com.denis.dao;

import com.denis.models.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by denis on 10/18/2015.
 */
@Repository
@Transactional
public class AddressDao {
    @PersistenceContext
    private EntityManager entityManager;


    public void save(Address address){
        if (address.getId() == null){
            entityManager.persist(address);
        } else {
            entityManager.merge(address);
        }
    }

    @Transactional
    public List<Address> fetchAll() {
        TypedQuery<Address> query = entityManager.createNamedQuery(Address.FIND_ALL, Address.class);
        return query.getResultList();
    }
}
