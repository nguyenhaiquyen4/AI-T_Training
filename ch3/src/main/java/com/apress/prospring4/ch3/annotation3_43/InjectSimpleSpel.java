package com.apress.prospring4.ch3.annotation3_43;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectSimpleSpel {
    @Value("#{injectSimpleSpelConfig.name}")
    private String name;
    @Value("#{injectSimpleSpelConfig.age + 1}")
    private int age;
    @Value("#{injectSimpleSpelConfig.height}")
    private float height;
    @Value("#{injectSimpleSpelConfig.programmer}")
    private boolean programmer;
    @Value("#{injectSimpleSpelConfig.ageInSeconds}")
    private Long ageInSeconds;
    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
//        ctx.refresh();
//        InjectSimpleSpel simple = (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");
//        System.out.println(simple);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectSimpleSpelConfig.class);

        InjectSimpleSpel simple = ctx.getBean(InjectSimpleSpel.class);
        System.out.println(simple);
    }
}
