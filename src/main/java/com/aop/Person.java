package com.aop;

public class Person {
    private String name;
    private String sureName;
    private int id;

    public void sysTest(){
      System.out.println("sysTest");
      if(getName().length()<2){
          throw new RuntimeException("Test Error");
      }
    }

    public void sysTest1(String test){
        System.out.println("sysTest1 : " + test);
    }


    public void sysTest2(){
        System.out.println("sysTest2");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
