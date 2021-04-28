package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("springAop.xml");
        Person person = context.getBean("proxyBean" , Person.class);
        person.sysTest();
    }
}
