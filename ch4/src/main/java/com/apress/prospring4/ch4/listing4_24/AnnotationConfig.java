package com.apress.prospring4.ch4.listing4_24;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.apress.prospring4.ch4.listing4_19.MessageDigester;

import java.security.MessageDigest;

@Configuration
public class AnnotationConfig {
    @Bean("shaDigestFactory")
    public MessageDigestFactory shaDigestFactory() {
        MessageDigestFactory ret = new MessageDigestFactory();
        ret.setAlgorithmName("SHA1");
        return ret;
    }

    @Bean("defaultDigestFactory")
    public MessageDigestFactory defaultDigestFactory() {
        MessageDigestFactory ret = new MessageDigestFactory();
        return ret;
    }

    @Bean("shaDigest")
    public Object shaDigest() {
        try {
            return shaDigestFactory().createInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean("defaultDigest")
    public Object defaultDigest() {
        try {
            return defaultDigestFactory().createInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean("digester")
    public MessageDigester MessageDigester() {
        MessageDigester ret = new MessageDigester();
        ret.setDigest1((MessageDigest)shaDigest());
        ret.setDigest2((MessageDigest)defaultDigest());
        return ret;
    }
}
