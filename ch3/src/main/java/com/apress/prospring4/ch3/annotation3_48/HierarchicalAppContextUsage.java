package com.apress.prospring4.ch3.annotation3_48;

import com.apress.prospring4.ch3.annotation3_43.InjectSimpleSpel;
import com.apress.prospring4.ch3.annotation3_43.InjectSimpleSpelConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
//        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
//        parent.load("classpath:META-INF/spring/parent.xml");
//        parent.refresh();
//        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
//        child.load("classpath:META-INF/spring/app-context-xml.xml");
//        child.setParent(parent);
//        child.refresh();
//        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
//        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
//        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");
//        System.out.println(target1.getVal());
//        System.out.println(target2.getVal());
//        System.out.println(target3.getVal());



//        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext(ParentConfig.class);
//        parent.refresh();
        AnnotationConfigApplicationContext child = new AnnotationConfigApplicationContext(ChildConfig.class, ParentConfig.class);
//        child.setParent(parent);
//        child.refresh();

        SimpleTarget target1 = (SimpleTarget) child.getBean("target1");
        SimpleTarget target2 = (SimpleTarget) child.getBean("target2");
        SimpleTarget target3 = (SimpleTarget) child.getBean("target3");
        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());
    }
}
