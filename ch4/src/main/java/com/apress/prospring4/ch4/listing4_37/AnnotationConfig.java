package com.apress.prospring4.ch4.listing4_37;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {
    @Bean("publisher")
    public Publisher Publisher() {
        return new Publisher();
    }

    @Bean("messageEventListener")
    public MessageEventListener MessageEventListener() {
        return new MessageEventListener();
    }
}
