package com.apress.prospring4.ch8;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJPASample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactService contactService = ctx.getBean(
                "jpaContactService", ContactService.class);
//        listContacts(contactService.findAll());
//        listContacts(contactService.findAllWithDetail());
//        Contact contact = contactService.findById(1L);
//        System.out.println(contact);
//        if (contact.getContactTelDetails() != null) {
//            for (ContactTelDetail contactTelDetail :
//                    contact.getContactTelDetails()) {
//                System.out.println(contactTelDetail);
//            }
//        }
//        if (contact.getHobbies() != null) {
//            for (Hobby hobby : contact.getHobbies()) {
//                System.out.println(hobby);
//            }
//        }

//        ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class);
//        contactSummaryUntype.displayAllContactSummary();

//        ContactSummaryService contactSummaryService = ctx.getBean("contactSummaryService",ContactSummaryService.class);
//        listContactSummary(contactSummaryService.findAll());

//        Contact contact = contactService.findById(14L);
//        contact.setFirstName("Beyonce");
//        contact.setLastName("The Game");
//        Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
//        ContactTelDetail toDeleteContactTel = null;
//        for (ContactTelDetail detail : contactTels){
//            if ("Mobile".equals(detail.getTelType())){
////                contact.removeContactTelDetail(detail);
//                toDeleteContactTel = detail;
//            }
//        }
//        contact.removeContactTelDetail(toDeleteContactTel);
////        contactTels.remove(toDeleteContactTel);
//        contactService.save(contact);
//        listContactsWithDetail(contactService.findAllWithDetail());

//        Contact contact = contactService.findById(16L);
//        contactService.delete(contact);
//        listContactsWithDetail(contactService.findAllWithDetail());

//        listContacts(contactService.findAllByNativeQuery());

        List<Contact> contacts = contactService.findByCriteriaQuery("Michael", "Jackson");
        listContactsWithDetail(contacts);
    }

    private static void listContacts(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts without details:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }

    private static void listContactSummary(List<ContactSummary> contactSummarys) {
        System.out.println("");
        System.out.println("Listing contacts summary:");
        for (ContactSummary contactSummary : contactSummarys) {
            System.out.println(contactSummary);
        }
    }

    private static void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail:
                        contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                } }
            if (contact.getHobbies() != null) {
                for (Hobby hobby: contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }
}