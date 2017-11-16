package com.apress.prospring4.ch11taskexe;

import org.springframework.core.task.TaskExecutor;

public class Task2Execute {
    private TaskExecutor taskExecutor;

    public void executeTask() {
        for (int i = 0; i < 100; i++) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from thread: "
                            + Thread.currentThread().getName());
                }
            });
        }
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
}