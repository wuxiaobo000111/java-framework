package com.bobo.springboot.learn.springbootstarterdemo.service;

public class HelloService {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 家乡
     */
    private String hometown;

    public HelloService(String name, Integer age, String hometown) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
    }

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String helloWorld() {
        return String.format("[name=%s, age=%d, hometown=%s]", this.name, this.age, this.hometown);
    }

}
