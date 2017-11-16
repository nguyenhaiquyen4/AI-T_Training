package com.quyen.ch10.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.xml.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan("com.quyen.ch10.converter")
public class AppConfig {
    @Bean
    public VietnameseName tranHungDao() {
        return new VietnameseName("Trần", "Hưng", "Đạo");
    }

    @Bean
    public AmericanName donaldTrump() {
        return new AmericanName("Donald", "Trump");
    }

    @Bean
    public Converter v2a() {
        return new V2A();
    }

    @Bean
    Converter a2v() {
        return new A2V();
    }

    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        Set<Converter> set = new HashSet<>();
        set.add(a2v());
        set.add(v2a());
        factory.setConverters(set);
        return factory;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        return factory;
    }


}
