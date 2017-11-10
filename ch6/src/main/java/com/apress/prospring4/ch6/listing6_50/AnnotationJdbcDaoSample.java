package com.apress.prospring4.ch6.listing6_50;

import com.apress.prospring4.ch6.listing6_3.ContactDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-annotation-6-53.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        System.out.println(contactDao.findFirstNameById(1l));
    }
}