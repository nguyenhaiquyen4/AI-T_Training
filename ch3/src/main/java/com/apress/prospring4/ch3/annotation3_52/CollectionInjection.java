package com.apress.prospring4.ch3.annotation3_52;

import com.apress.prospring4.ch3.annotation3_48.ChildConfig;
import com.apress.prospring4.ch3.annotation3_48.ParentConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-3-52.xml");
        ctx.refresh();
        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ChildConfig.class, CollectionInjectionConfig.class);
//        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
//        instance.displayInfo();
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void displayInfo() {
        System.out.println("Map contents:\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\nProperties contents:\n");
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
        System.out.println("\nSet contents:\n");
        for (Object obj : set) {
            System.out.println("Value: " + obj);
        }
        System.out.println("\nList contents:\n");
        for (Object obj : list) {
            System.out.println("Value: " + obj);
        }
    }
}
