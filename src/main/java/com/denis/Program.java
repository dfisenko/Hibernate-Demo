package com.denis;

import com.denis.dao.AddressDao;
import com.denis.models.Address;
import com.denis.models.Person;
import com.denis.services.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denis on 10/17/2015.
 */
public class Program {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonService personService = (PersonService) context.getBean("personService");
        AddressDao addressDao = context.getBean(AddressDao.class);


        Person person = new Person();
        person.setName("Alba");
        person.setEmail("alba@gmail.com");
        personService.addPerson(person);

        System.out.println("Person : " + person + " added successfully");



        Address address = new Address();
        address.setCity("Renton");
        address.setCountry("USA");
        address.setZip("98056");
        address.setState("WA");
        address.setStreet("300 Vuemont PL NE");



        person.setName("John");
        person.addAddress(address);

        personService.addPerson(person);


        Controller controller = context.getBean(Controller.class) ;

        controller.doSomeStuff();

        controller.showJohn();
        controller.showJohn();
        controller.showWithoutAddress();












    }
}
