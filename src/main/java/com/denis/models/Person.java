package com.denis.models;

import javax.persistence.*;

/**
 * Created by denis on 10/17/2015.
 */
@Table
@Entity
@NamedQueries({
        @NamedQuery(name = "Select.All", query = "SELECT p FROM Person p"),
        @NamedQuery(name = "Count.All", query = "SELECT COUNT(1) FROM Person p")
})
public class Person {

    public static final String SELECT_ALL_QUERY = "Select.All";
    public static final String COUNT_ALL_QUERY = "Count.All";

    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
