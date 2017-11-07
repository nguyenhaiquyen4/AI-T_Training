package com.apress.prospring4.ch4.listing4_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class SimpleBeanWithInterfaceConfig {
    @Bean("simpleBean1")
    public SimpleBeanWithInterface SimpleBeanWithInterface1() {
        SimpleBeanWithInterface ret = new SimpleBeanWithInterface();
        ret.setAge(32);
        ret.setName("Chris Schaefer");
        return ret;
    }

    @Bean(value="simpleBean2",initMethod = "myInit")
    public SimpleBeanWithInterface SimpleBeanWithInterface2() {
        SimpleBeanWithInterface ret = new SimpleBeanWithInterface();
        ret.setAge(32);
        return ret;
    }

    @Bean("simpleBean3")
    @Lazy(true)
    public SimpleBeanWithInterface SimpleBeanWithInterface3() {
        SimpleBeanWithInterface ret = new SimpleBeanWithInterface();
        ret.setName("Chris Schaefer");
//        ret.setAge(32);
        return ret;
    }
}
