package com.denis.models;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by denis on 10/17/2015.
 */
@Table(name = "PERSON")
@Entity
@NamedQueries({
        @NamedQuery(name = "Select.All", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Count.All", query = "SELECT COUNT(1) FROM Person p"),
        @NamedQuery(name = "Person.Find.By.Name", query = "SELECT p FROM Person p WHERE p.name = :name")
})
public class Person {

    public static final String SELECT_ALL_QUERY = "Select.All";
    public static final String COUNT_ALL_QUERY = "Count.All";
    public static final String FIND_BY_NAME_QUERY = "Person.Find.By.Name";
    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;


    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;


    public List<Address> getAddresses() {
        if (this.addresses == null){
            this.addresses = new LinkedList<Address>();
        }
        return addresses;
    }


    public void addAddress(Address address){
        getAddresses().add(address);
        address.setPerson(this);
    }

    public void removeAddress(Address address){
        getAddresses().remove(address);
        address.setPerson(null);
    }




    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
