package com.apress.prospring4.ch11taskexe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AppConfig {
    @Bean
    public Task2Execute taskExecutorSample() {
        Task2Execute ret = new Task2Execute();
        ret.setTaskExecutor(taskExecutor());
        return ret;
    }

    @Bean
    public SimpleAsyncTaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}
