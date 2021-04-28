package com.springJDBC;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        Person person = new Person("ali" , "sarp");
        PersonDao personDao = context.getBean("personDaoImpl" , PersonDao.class);
       // personDao.addPerson(person);
       // personDao.createPerson(person);
        personDao.updatePerson(person , 1);
        List<Person> personList = personDao.getAllPersons();
        for(Person person1 : personList){
            System.out.println(person1);
        }

        Person person1 = personDao.readPerson(1);
        System.out.println(person1);

    }
}
