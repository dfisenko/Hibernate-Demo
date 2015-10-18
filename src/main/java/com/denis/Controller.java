package com.denis;

import com.denis.dao.AddressDao;
import com.denis.dao.PersonDao;
import com.denis.models.Address;
import com.denis.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by denis on 10/18/2015.
 */
@Transactional
@Service
public class Controller {

    @Autowired
    PersonDao personDao;
    @Autowired
    AddressDao addressDao;



    @Transactional(propagation = Propagation.REQUIRED)
    public Person doSomeStuff(){

        List<Person> persons = personDao.selectAll();


        System.out.println(Arrays.toString(persons.toArray()));


        for (Person person : persons){
            System.out.println(person.getAddresses().get(0));
        }
        return null;
    }

    public void showJohn(){
        Person p = personDao.getByName("John");
        System.out.println("==================");
        System.out.println(p);
        System.out.println("============");

        int addresscount = p.getAddresses().size();
        System.out.println("addresses count: " + addresscount);
        if (addresscount != 0){
            Address a = p.getAddresses().get(0);
            System.out.println(a);
            p.removeAddress(a);

        } else {
            System.out.println("No adresses found");
        }
    }

    public void showWithoutAddress(){
        Person p = personDao.getByName("John");
    }
}
