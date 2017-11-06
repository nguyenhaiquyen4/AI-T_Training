package com.apress.prospring4.ch3.annotation3_43;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class InjectSimpleSpelConfig {
    public String name = "John Smith Thui";
    public int age = 35;
    public float height = 1.78f;
    public boolean programmer = true;
    public Long ageInSeconds = 1103760000L;

    @Bean
    public InjectSimpleSpel AacdInjectSimpleSpel() {
        System.out.println("aaaa");
        return new InjectSimpleSpel();
    }
}
