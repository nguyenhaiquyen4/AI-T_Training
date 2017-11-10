package com.apress.prospring4.ch7new;

import java.util.List;
import java.util.Date;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
//        listContacts(contactDao.findAll());
//        listContactsWithDetail(contactDao.findAll());
//        listContactsWithDetail(contactDao.findAllWithDetail());
//
//        Contact contact = contactDao.findById(1l);
//        System.out.println("");
//        System.out.println("Contact with id 1:" + contact);
//        System.out.println("");
//
//        Contact contact = new Contact();
//        contact.setFirstName("Michael1");
//        contact.setLastName("Jackson");
//        contact.setBirthDate(new Date());
//        ContactTelDetail contactTelDetail =
//                new ContactTelDetail("Home", "1111111111");
//        contact.addContactTelDetail(contactTelDetail);
//        contactTelDetail = new ContactTelDetail("Mobile", "2222222222");
//        contact.addContactTelDetail(contactTelDetail);
//        contactDao.save(contact);
//        listContactsWithDetail(contactDao.findAllWithDetail());

//        Contact contact = contactDao.findById(1l);
//        contact.setFirstName("Kim Fung");
//        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//        ContactTelDetail toDeleteContactTel = null;
//        for (ContactTelDetail contactTel: contactTels) {
//            if (contactTel.getTelType().equals("Home")) {
//                toDeleteContactTel = contactTel;
//            }
//        }
//        contact.removeContactTelDetail(toDeleteContactTel);
//        contactDao.save(contact);
//        listContactsWithDetail(contactDao.findAllWithDetail());


        Contact contact = contactDao.findById(1l);
        contactDao.delete(contact);
        listContactsWithDetail(contactDao.findAllWithDetail());
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail :
                        contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

}