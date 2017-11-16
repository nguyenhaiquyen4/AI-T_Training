package com.apress.prospring4.ch11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ScheduleTaskSample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/task-namespace-app-context.xml");
//        ctx.refresh();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        while (true) {
        }

//        CarService s = ctx.getBean("carService",CarService.class);
//        s.findAll().forEach(System.out::println);
    }
}