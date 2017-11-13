package com.apress.prospring4.ch8;

import java.util.List;
import java.util.Date;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPASample2 {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactAuditService contactService = ctx.getBean(
                "contactAuditService", ContactAuditService.class);
        List<ContactAudit> contacts = contactService.findAll();
        listContacts(contacts);
        System.out.println("Add new contact");
        ContactAudit contact = new ContactAudit();
        contact.setFirstName("Michael");
        contact.setLastName("Jackson");
        contact.setBirthDate(new Date());
        contactService.save(contact);
        contacts = contactService.findAll();
        listContacts(contacts);
//        contact = contactService.findById(3l);
//        System.out.println("");
//        System.out.println("Contact with id 1:" + contact);
//        System.out.println("");
//        System.out.println("Update contact");
//        contact.setLastName("lon ton");
//        contactService.save(contact);
//        contacts = contactService.findAll();
//        listContacts(contacts);

        System.out.println("Update contact");
        contact.setFirstName("Tom");
        contactService.save(contact);
        listContacts(contactService.findAll());
        ContactAudit oldContact = contactService.findAuditByRevision(1l, 1);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 1:" + oldContact);
        System.out.println("");
        oldContact = contactService.findAuditByRevision(1l, 2);
        System.out.println("");
        System.out.println("Old Contact with id 1 and rev 2:" + oldContact);
        System.out.println("");
    }

    private static void listContacts(List<ContactAudit> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (ContactAudit contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}