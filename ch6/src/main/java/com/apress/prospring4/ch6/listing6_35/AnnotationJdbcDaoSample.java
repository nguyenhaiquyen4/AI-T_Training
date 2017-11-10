package com.apress.prospring4.ch6.listing6_35;

import java.util.List;

import com.apress.prospring4.ch6.listing6_3.Contact;
import com.apress.prospring4.ch6.listing6_3.ContactTelDetail;
import com.apress.prospring4.ch6.listing6_32.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        // MODIFY CONPONENT SCAN IN XML FILE BEFORE RUN THIS
        ctx.load("app-context-annotation-6-34.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = contactDao.findAll();
        listContacts(contacts);
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            System.out.println();
        }
    }
}