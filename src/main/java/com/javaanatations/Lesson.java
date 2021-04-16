package com.javaanatations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Lesson {

    @Autowired
    @Qualifier("beanStudent1")
    private Student student;

    private int id;
    private String nm;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    @PostConstruct
    public void init(){
        System.out.println("init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy method");
    }

}
