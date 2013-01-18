package com.regina.controller;

import com.regina.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Carlos
 */

@Stateless
public class PersonEJB {
    @PersistenceContext(unitName = "reginaPU")
    private EntityManager em;

    public List<Person> findPersons() {
        TypedQuery<Person> query = em.createNamedQuery("findAllPersons", Person.class);
        return query.getResultList();
    }

    public Person createPerson(Person person) {
        em.persist(person);
        return person;
    }
}
