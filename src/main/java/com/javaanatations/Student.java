package com.javaanatations;

import org.springframework.beans.factory.annotation.Required;

public class Student {
    private int age;
    private String name , sureName;

    public Student (){
       System.out.println("No args constructur");
    }

    public Student(int age, String name, String sureName) {
        this.age = age;
        this.name = name;
        this.sureName = sureName;
    }

    public int getAge() {
        return age;
    }

    @Required
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }
}
