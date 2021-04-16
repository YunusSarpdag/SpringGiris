package com.springstart;

public class Audi {
    private Oil oil;
    private String name;
    private String type;

    public Audi(Oil oil) {
      this.oil = oil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Audi(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void hareketeGec(){
        oil.depo();
        System.out.println(getName() + "  Araba harekete geçti , type  " + getType());
    }
}
