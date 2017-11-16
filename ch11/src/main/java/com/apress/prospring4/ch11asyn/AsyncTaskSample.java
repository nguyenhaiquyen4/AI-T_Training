package com.apress.prospring4.ch11asyn;

import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncTaskSample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AsyncService asyncService = ctx.getBean("asyncService", AsyncService.class);
        for (int i = 0; i < 5; i++) {
            asyncService.asyncTask();
        }
        Future<String> result1 = asyncService.asyncWithReturn("Chris");
        Future<String> result2 = asyncService.asyncWithReturn("John");
        Future<String> result3 = asyncService.asyncWithReturn("Robert");
        try {
            Thread.sleep(6000);
            System.out.println("Result1: " + result1.get());
            System.out.println("Result2: " + result2.get());
            System.out.println("Result3: " + result3.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}