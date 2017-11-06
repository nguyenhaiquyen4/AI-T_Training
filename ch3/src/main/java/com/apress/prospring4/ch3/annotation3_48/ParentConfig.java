package com.apress.prospring4.ch3.annotation3_48;

import com.apress.prospring4.ch3.annotation3_43.InjectSimpleSpel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Configuration
public class ParentConfig {
    @Bean
    public SimpleTarget SimpleTarget() {
        System.out.println("aaaa");
        return new SimpleTarget();
    }

    public String injectBean="Bean In Parent";
}
