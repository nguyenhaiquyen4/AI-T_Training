package com.apress.prospring4.ch4.listing4_19;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {
    @Bean("shaDigest")
    public MessageDigestFactoryBean MessageDigestFactoryBeanshaDigest() {
        MessageDigestFactoryBean ret = new MessageDigestFactoryBean();
        ret.setAlgorithmName("SHA1");
        return ret;
    }

    @Bean("defaultDigest")
    public MessageDigestFactoryBean MessageDigestFactoryBeandefaultDigest() {
        MessageDigestFactoryBean ret = new MessageDigestFactoryBean();
        return ret;
    }

    @Bean("digester")
    public MessageDigester MessageDigester() {
        MessageDigester ret = new MessageDigester();
        try {
            ret.setDigest1(MessageDigestFactoryBeanshaDigest().getObject());
            ret.setDigest2(MessageDigestFactoryBeandefaultDigest().getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
