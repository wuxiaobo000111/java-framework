package com.spring.bobo.learn.bean.staticFactroy;

public class Dog implements Being {

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public void testBeing() {
        System.out.println(msg+",狗爱吃骨头");
    }
}
