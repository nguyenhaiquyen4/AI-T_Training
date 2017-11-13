package com.apress.prospring4.ch9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TxJtaSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/tx-jta-app-context.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactService contactService = ctx.getBean("contactService",
                ContactService.class);
        Contact contact = new Contact();
        contact.setFirstName("Jta");
        contact.setLastName("Manager");
        contactService.save(contact);
        System.out.println("Contact saved successfully");
        contactService.findAll().forEach(System.out::println);
    }
}
