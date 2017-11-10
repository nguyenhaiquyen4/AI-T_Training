package com.apress.prospring4.ch5bis.listing5_61;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-config-xml-5-64.xml");
        ctx.refresh();
        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
