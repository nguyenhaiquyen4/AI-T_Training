package com.apress.prospring4.ch4.listing4_16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {
    @Bean("shutdownHook")
    public ShutdownHookBean ShutdownHookBean() {
        return new ShutdownHookBean();
    }

    @Bean("destructiveBean")
    public DestructiveBeanWithInterface DestructiveBeanWithInterface() {
        DestructiveBeanWithInterface ret = new DestructiveBeanWithInterface();
        ret.setFilePath(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "test.txt");
        return ret;
    }
}
