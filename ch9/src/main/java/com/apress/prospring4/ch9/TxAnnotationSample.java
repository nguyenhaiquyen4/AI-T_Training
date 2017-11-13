package com.apress.prospring4.ch9;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxAnnotationSample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactService contactService = ctx.getBean("contactService",
                ContactService.class);
        List<Contact> contacts = contactService.findAll();
        for (Contact contactTemp : contacts) {
            System.out.println(contactTemp);
        }

        Contact contact = contactService.findById(1L);
        System.out.println(contact);
        contact.setFirstName("Pepe");
        System.out.println(contact);
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);

        contacts = contactService.findAll();
        contacts.forEach(System.out::println);

        System.out.println("Count = "+contactService.countAll());
    }
}