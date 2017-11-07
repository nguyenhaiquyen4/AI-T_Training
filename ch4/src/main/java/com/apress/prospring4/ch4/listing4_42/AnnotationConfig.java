package com.apress.prospring4.ch4.listing4_42;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {
    @Bean("messageRenderer")
    public StandardOutMessageRenderer StandardOutMessageRenderer() {
        StandardOutMessageRenderer ret =  new StandardOutMessageRenderer();
        ret.setMessageProvider(ConfigurableMessageProvider());
        return ret;
    }

    @Bean("messageProvider")
    public ConfigurableMessageProvider ConfigurableMessageProvider() {
        ConfigurableMessageProvider ret = new ConfigurableMessageProvider();
        ret.setMessage("This is a configurable message");
        return ret;
    }
}
