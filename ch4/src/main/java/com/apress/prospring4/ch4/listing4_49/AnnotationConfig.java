package com.apress.prospring4.ch4.listing4_49;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AnnotationConfig {
    @Bean("foodProviderService")
    @Profile("kindergarten")
    public FoodProviderService kindergarten() {
        FoodProviderService ret = new com.apress.prospring4.ch4.listing4_49.kindergarten.FoodProviderServiceImpl();
        return ret;
    }

    @Bean("foodProviderService")
    @Profile("highschool")
    public FoodProviderService highschool() {
        FoodProviderService ret = new com.apress.prospring4.ch4.listing4_49.highschool.FoodProviderServiceImpl();
        return ret;
    }
}
