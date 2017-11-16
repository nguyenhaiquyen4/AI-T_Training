package com.apress.prospring4.ch10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@ComponentScan("com.apress.prospring4.ch10")
@Configuration
public class JSR349AppConfig {
    @Bean("validator")
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
}
