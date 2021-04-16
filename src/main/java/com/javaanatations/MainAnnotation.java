package com.javaanatations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springJavaAnnatation.xml");
        Student student = (Student) context.getBean("beanStudent");
        System.out.println(student.getAge());

        Lesson lesson = (Lesson) context.getBean("beanLesson");
        System.out.println("lesson student : "  +lesson.getStudent().getName());

        ((AbstractApplicationContext)context).registerShutdownHook();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpringBeanConfig.class);
        annotationConfigApplicationContext.refresh();

        City city = annotationConfigApplicationContext.getBean(City.class);
        System.out.println("city : " +city.getNm());

        Adress adress = annotationConfigApplicationContext.getBean(Adress.class);
        System.out.println("adress city : " +adress.getCity().getNm());

        annotationConfigApplicationContext.destroy();

    }
}
