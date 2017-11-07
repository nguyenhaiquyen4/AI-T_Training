package com.apress.prospring4.ch4.listing4_58;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


// How to local-override ?
@Configuration
@PropertySource(value="classpath:application.properties")
public class AppConfig {
    @Autowired
    Environment env;

    @Bean("appProperty")
    public AppProperty AppProperty() {
        AppProperty ret = new AppProperty();
        ret.setApplicationHome(env.getProperty("application.home"));
        ret.setUserHome(env.getProperty("user.home"));
        return ret;
    }
}
