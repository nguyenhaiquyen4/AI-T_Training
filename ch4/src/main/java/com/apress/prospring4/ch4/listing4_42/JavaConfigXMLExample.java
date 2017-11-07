package com.apress.prospring4.ch4.listing4_42;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigXMLExample {
    public static void main(String[] args) {
//        ApplicationContext ctx = new
//                ClassPathXmlApplicationContext("app-context-xml-4-44.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        MessageRenderer renderer =
                ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }

}
