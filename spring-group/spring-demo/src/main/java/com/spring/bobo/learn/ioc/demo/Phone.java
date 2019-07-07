package com.spring.bobo.learn.ioc.demo;

public class Phone {
    private String price;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Phone() {
    }

    public String getPrice() {
        return price;
    }

    public Phone(String price, String name) {
        this.price = price;
        this.name = name;
    }
}
