package com.bobo.spring.learn.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class Test {

    public static void main(String[] args) throws IOException {

        /**
         * 	super();
         * 		ignoreDependencyInterface(BeanNameAware.class);
         * 		ignoreDependencyInterface(BeanFactoryAware.class);
         * 		ignoreDependencyInterface(BeanClassLoaderAware.class);
         *  XmlBeanFactory构造函数中移除了这三个接口
         */
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("mytest.xml"));
        MyTestBean bean = factory.getBean(MyTestBean.class);
        System.out.println(bean.getTestStr());

        MyTestBean myTestBean = BeanUtils.instantiateClass(MyTestBean.class);
        System.out.println(myTestBean.getTestStr());
    }

}