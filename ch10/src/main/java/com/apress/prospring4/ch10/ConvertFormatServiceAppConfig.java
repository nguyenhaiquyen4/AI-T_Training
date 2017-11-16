package com.apress.prospring4.ch10;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.URL;

@Configuration
public class ConvertFormatServiceAppConfig {
    @Bean("conversionService")
    public ApplicationConversionServiceFactoryBean conversionService() {
        ApplicationConversionServiceFactoryBean ret =new ApplicationConversionServiceFactoryBean();
        return ret;
    }

    @Bean("chris")
    public Contact chris() {
        Contact contact = new Contact();
        contact.setFirstName("AAA");
        contact.setLastName("BBB");
        contact.setBirthDate(new DateTime("1981-05-03"));
        try {
            contact.setPersonalSite(new URL("http://www.dtzq.com"));
        } catch (Exception ex) {
        }
        return contact;
    }
}
