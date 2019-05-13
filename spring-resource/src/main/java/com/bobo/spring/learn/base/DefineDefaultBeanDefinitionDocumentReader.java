package com.bobo.spring.learn.base;

import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;

public class DefineDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {

    @Override
    protected void preProcessXml(Element root) {
        System.out.println("DefaultBeanDefinitionDocumentReader before");
    }

    @Override
    protected void postProcessXml(Element root) {
        System.out.println("DefaultBeanDefinitionDocumentReader after");
    }
}
