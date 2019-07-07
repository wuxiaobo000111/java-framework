package com.spring.bobo.learn.ioc.demo;

public class Person {
    private String name;
    private Phone phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Phone getPhone() {
        return phone;
    }

    public void callphone () {
        System.out.println(this.name + "使用"+phone.getName()+"打电话");
    }

    public Person(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }
}
