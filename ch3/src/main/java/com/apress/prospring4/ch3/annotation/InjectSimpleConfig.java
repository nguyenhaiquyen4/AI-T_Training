package com.apress.prospring4.ch3.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectSimpleConfig {
    @Bean
    public InjectSimple InjectSimple(){
        return new InjectSimple();
    }
}
