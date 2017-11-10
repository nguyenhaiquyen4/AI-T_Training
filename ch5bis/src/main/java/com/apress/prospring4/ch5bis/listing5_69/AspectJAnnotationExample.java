package com.apress.prospring4.ch5bis.listing5_69;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-config-xml-5-72.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
