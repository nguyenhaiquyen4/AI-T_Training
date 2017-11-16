package com.apress.prospring4.ch11taskexe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskExecutorSample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Task2Execute taskToExecute = ctx.getBean(Task2Execute.class);
        taskToExecute.executeTask();
    }
}
