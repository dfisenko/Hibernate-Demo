package com.denis;

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

        Person person = new Person();
        person.setName("Alba");
        person.setEmail("alba@gmail.com");
        personService.addPerson(person);
        System.out.println("Person : " + person + " added successfully");

        System.out.println("Total count of persons: " + personService.getCount());




    }
}
