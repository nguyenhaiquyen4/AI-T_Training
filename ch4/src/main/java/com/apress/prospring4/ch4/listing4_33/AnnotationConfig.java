package com.apress.prospring4.ch4.listing4_33;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AnnotationConfig {
    @Bean("messageSource")
    public ResourceBundleMessageSource ResourceBundleMessageSource() {
        ResourceBundleMessageSource ret = new ResourceBundleMessageSource();
        ret.setBasenames(stringList());
        return ret;
    }

    @Bean("basenames")
    public String[] stringList() {
        String[] ret = {"buttons", "labels"};
        return ret;
    }
}
