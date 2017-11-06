package com.apress.prospring4.ch3.annotation3_25;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
//        ctx.refresh();
//        MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
//                MessageRenderer.class);
//        messageRenderer.render();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AutowireConfig.class);

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
                MessageRenderer.class);
        messageRenderer.render();
    }
}
