package com.apress.prospring4.ch4.listing4_41;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileNotFoundException;

public class ResourceDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();
        System.out.println(file.getPath());
        Resource res1 = ctx.getResource("file://" + file.getPath());
        displayInfo(res1);
        Resource res2 = ctx.getResource("classpath:test.txt");
        displayInfo(res2);
        Resource res3 = ctx.getResource("http://www.google.com");
        displayInfo(res3);
    }

    private static void displayInfo(Resource res) throws Exception {
        System.out.println(res.getClass());
        try {
            System.out.println(res.getURL().getContent());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("");
    }
}
