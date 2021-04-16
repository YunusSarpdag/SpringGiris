package com.springanatations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Oil oil = (Oil) applicationContext.getBean("oil");
        oil.depo();

        Car car = (Car) applicationContext.getBean("car");
        car.setName("mycar");
        car.hareketeGec();

        Car car2 = (Car) applicationContext.getBean("car");
        car2.hareketeGec();  // cause our bean is singleton
        ((AbstractApplicationContext) applicationContext).registerShutdownHook(); // destroy context
    }
}
