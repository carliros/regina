package com.regina.controller;

import com.regina.model.Person;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos
 */

@ManagedBean
@RequestScoped
public class PersonController {
    @EJB
    private PersonEJB personEJB;

    private Person person = new Person();
    private List<Person> personList = new ArrayList<Person>();

    public String doCreatePerson() {
        person = personEJB.createPerson(person);
        personList = personEJB.findPersons();
        return "listPersons.xhtml";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        return personEJB.findPersons();
    }
}
