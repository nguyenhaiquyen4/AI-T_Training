package com.apress.prospring4.ch6.listing6_17;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("datasource-drivermanager-6-10.xml");
        ctx.load("app-context-xml-6-19.xml");
        ctx.refresh();
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        System.out.println("First name for contact id 1 is: " +
                contactDao.findFirstNameById(1l));
    }
}
