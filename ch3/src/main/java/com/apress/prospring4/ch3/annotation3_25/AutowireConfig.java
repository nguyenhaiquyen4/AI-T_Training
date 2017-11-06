package com.apress.prospring4.ch3.annotation3_25;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowireConfig {
    @Bean
    public MessageProvider MessageProvider() {
        MessageProvider ret = new HelloWorldMessageProvider();
        return ret;
    }

    @Bean("messageRenderer")
    public MessageRenderer MessageRenderer() {
        MessageRenderer ret = new StandardOutMessageRenderer();
        return ret;
    }
}
