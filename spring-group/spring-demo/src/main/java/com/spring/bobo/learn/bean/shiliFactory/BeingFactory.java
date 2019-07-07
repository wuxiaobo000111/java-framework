package com.spring.bobo.learn.bean.shiliFactory;

import com.spring.bobo.learn.bean.staticFactroy.Being;
import com.spring.bobo.learn.bean.staticFactroy.Cat;
import com.spring.bobo.learn.bean.staticFactroy.Dog;

public class BeingFactory {

    public Being getBeing(String arg) {
        if (arg.equalsIgnoreCase("dog")) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
