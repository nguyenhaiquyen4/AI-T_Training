package com.apress.prospring4.ch6.listing6_47;

import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.sql.Date;

import com.apress.prospring4.ch6.listing6_3.Contact;
import com.apress.prospring4.ch6.listing6_3.ContactDao;
import com.apress.prospring4.ch6.listing6_3.ContactTelDetail;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        // MODIFY CONPONENT SCAN IN XML FILE BEFORE RUN THIS
//        ctx.load("app-context-annotation-6-34.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
//        Contact contact = new Contact();
//        contact.setFirstName("Michael");
//        contact.setLastName("Jackson");
//        contact.setBirthDate(new Date((new GregorianCalendar(1964, 10, 1)).getTime().getTime()));
//        List<ContactTelDetail> contactTelDetails = new ArrayList<ContactTelDetail>();
//        ContactTelDetail contactTelDetail = new ContactTelDetail();
//        contactTelDetail.setTelType("Home");
//        contactTelDetail.setTelNumber("11111111");
//        contactTelDetails.add(contactTelDetail);
//        contactTelDetail = new ContactTelDetail();
//        contactTelDetail.setTelType("Mobile");
//        contactTelDetail.setTelNumber("22222222");
//
//        contactTelDetails.add(contactTelDetail);
//        contact.setContactTelDetails(contactTelDetails);
//        contactDao.insertWithDetail(contact);
        listContacts(contactDao.findAllWithDetail());
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