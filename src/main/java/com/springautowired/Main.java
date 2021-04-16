package com.springautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAtoWired.xml");

        Personel personel = (Personel) context.getBean("beanPersonel");
        System.out.println(personel.getNm());
        System.out.println(personel.getSureName());
        System.out.println(personel.getAdress().getFullAdress());
        ((ConfigurableApplicationContext)context).registerShutdownHook();
    }
}
