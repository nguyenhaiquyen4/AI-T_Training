package com.apress.prospring4.ch4.listing4_49;

import com.apress.prospring4.ch4.listing4_48.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-xml-4-49-*.xml");
//        ctx.refresh();
        ApplicationContext ctx = new
                AnnotationConfigApplicationContext(AnnotationConfig.class);
        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        for (Food food : lunchSet) {
            System.out.println("Food: " + food.getName());
        }
    }
}
