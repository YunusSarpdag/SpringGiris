package com.springJDBC;

public class Person {
    private String name;
    private String sureName;
    private int personId;

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Person(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    public Person() {
    }

    public Person(String name, String sureName, int personId) {
        this.name = name;
        this.sureName = sureName;
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", personId=" + personId +
                '}';
    }
}
