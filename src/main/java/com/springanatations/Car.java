package com.springanatations;

import com.springanatations.Oil;

public class Car {
    private Oil oil;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(Oil oil) {
        this.oil = oil;
    }

    public void hareketeGec(){
        oil.depo();
        System.out.println(getName() + "  Araba harekete geçti");
    }

    public void init(){
        System.out.println("bean start ....");
    }

    public void destroy(){
        System.out.println("bean destroyed .....");
    }
}
