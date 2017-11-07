package com.apress.prospring4.ch4.listing4_19;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class MessageDigestExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-xml-4-21.xml");
//        ctx.refresh();

        AnnotationConfigApplicationContext ctx = null;
        ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");

        MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
        MessageDigestFactoryBean factoryBean =
                (MessageDigestFactoryBean) ctx.getBean("&shaDigest");

        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println("ddd "+shaDigest.digest("Hello world".getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
