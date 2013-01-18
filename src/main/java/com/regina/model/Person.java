package com.regina.model;

import javax.persistence.*;

/**
 * @author Carlos
 */

@Entity
@NamedQuery(name = "findAllPersons"
        , query = "SELECT p FROM Person p")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() {
        return id;
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
}
