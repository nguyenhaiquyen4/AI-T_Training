package com.apress.prospring4.ch6.listing6_44;

import java.util.List;
import java.util.GregorianCalendar;
import java.sql.Date;

import com.apress.prospring4.ch6.listing6_3.Contact;
import com.apress.prospring4.ch6.listing6_3.ContactDao;
import com.apress.prospring4.ch6.listing6_3.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        // MODIFY CONPONENT SCAN IN XML FILE BEFORE RUN THIS
        ctx.load("app-context-annotation-6-34.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");
        contact.setBirthDate(new Date((new GregorianCalendar(2001, 10, 1)).getTime().getTime()));
        contactDao.insert(contact);
        listContacts(contactDao.findAll());
    }

    private static void listContacts(List<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println("---" + contactTelDetail);
                }
            }
            else {
                System.out.println("null eo ooi");
            }
            System.out.println();
//            JDBC operations:inserting data and generated key
        }
    }
}
