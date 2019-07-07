package com.spring.bobo.learn.bean.staticFactroy;

public class Cat implements Being {

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public void testBeing() {
        System.out.println(msg+", 猫爱吃老鼠");
    }
}
