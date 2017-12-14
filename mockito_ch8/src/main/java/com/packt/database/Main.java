package com.packt.database;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.packt.database.dao.PhoneBookDerbyDao;
import com.packt.database.model.PhoneEntry;

public class Main {
    public static void main(String... args) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PhoneBookDerbyDao phoneBookDao = ctx.getBean("phoneBookDao", PhoneBookDerbyDao.class);
        listContacts(phoneBookDao.searchByFirstName("Scott"));
    }

    private static void listContacts(List<PhoneEntry> contacts) {
        for (PhoneEntry contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}
