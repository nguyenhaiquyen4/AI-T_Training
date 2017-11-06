package com.apress.prospring4.ch3.annotation3_52;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectionInjectionConfig {
    @Bean("injectCollection")
    public CollectionInjection CollectionInjection() {
        CollectionInjection ret = new CollectionInjection();
        return ret;
    }
}
