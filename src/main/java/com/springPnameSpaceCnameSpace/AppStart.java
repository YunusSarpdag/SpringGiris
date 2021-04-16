package com.springPnameSpaceCnameSpace;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class AppStart {
    public static void main(String[] args) {

        BeanFactory beanFactory = new XmlBeanFactory
                (new FileSystemResource("springConfig.xml")) ;
        Student student = (Student) beanFactory.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getSureName());
        System.out.println(student.getNumber());
        System.out.println(student.getSchool().getSchoolName());
        // spring xml p:namespace example

        Lesson lesson = (Lesson) beanFactory.getBean("lesson");
        System.out.println(lesson.getName());
        // spring xml c:namespace example
    }
}
