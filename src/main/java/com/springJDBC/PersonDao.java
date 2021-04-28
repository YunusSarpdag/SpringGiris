package com.springJDBC;

import java.util.List;

public interface PersonDao {
    public void addPerson(Person person);
    public Person getPersonById(int id);
    public List<Person> getAllPersons();


    //--------jdbc template------
    public void createPerson(Person person);
    public void deletePerson(int id);
    public void updatePerson(Person person , int id);
    public Person readPerson(int id);
}
