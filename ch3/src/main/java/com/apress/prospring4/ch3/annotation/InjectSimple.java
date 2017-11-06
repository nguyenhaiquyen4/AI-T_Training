package com.apress.prospring4.ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectSimple {
    @Value("Chris Schaefer")
    private String name;

    @Value("32")
    private int age;

    @Value("1.778")
    private float height;

    @Value("true")
    private boolean programmer;

    @Value("1009843200")
    private Long ageInSeconds;

    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-annotation.xml");
//        ctx.refresh();
//        InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
//        System.out.println(simple);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectSimpleConfig.class);

        InjectSimple simple = ctx.getBean(InjectSimple.class);
        System.out.println(simple);
    }

    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Age in Seconds: " + ageInSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
}
