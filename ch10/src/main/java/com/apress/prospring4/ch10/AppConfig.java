package com.apress.prospring4.ch10;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.env.Environment;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
//    @Autowired
//    public Environment env;
//
//    @Value("${date.format.pattern}")
//    public String dateformatpattern;
//
//    @Value("${myContact.firstName}")
//    public String firstName;
//
//    @Value("${myContact.lastName}")
//    public String lastName;
//
//    @Value("${myContact.birthDate}")
//    public String birthDate;
//
//    @Value("${myContact.personalSite}")
//    public String url;
//
//    @Bean("customEditorConfigurer")
//    public CustomEditorConfigurer customEditorConfigurer() {
//        CustomEditorConfigurer ret = new CustomEditorConfigurer();
//        ret.setPropertyEditorRegistrars((DateTimeEditorRegistrar[])(propertyEditorRegistrarsList().toArray()));
//        return ret;
//    }
//
//    @Bean("propertyEditorRegistrarsList")
//    public List<DateTimeEditorRegistrar> propertyEditorRegistrarsList() {
//        List<DateTimeEditorRegistrar> ret = new ArrayList<>(10);
//        for (DateTimeEditorRegistrar r : ret){
//            r = new DateTimeEditorRegistrar(dateformatpattern);
//        }
//        return ret;
//    }
//
//    @Bean("chris")
//    public Contact chris() {
//        Contact c = new Contact();
//        c.setFirstName("Chris");
//        c.setLastName("Schaefer");
//        c.setBirthDate(new DateTime("1981-05-03"));
//        try {
//            c.setPersonalSite(new URL("http://www.dtzq.com"));
//        } catch (Exception ex) {
//        }
//        return c;
//    }
//
//    @Bean("myContact")
//    public Contact myContact() {
//        Contact c = new Contact();
//        c.setFirstName(firstName);
//        c.setLastName(lastName);
//        c.setBirthDate(new DateTime(birthDate));
//        try {
//            c.setPersonalSite(new URL(url));
//        } catch (Exception ex) {
//        }
//        return c;
//    }

//    @Bean
//    public ConversionServiceFactoryBean aa() {
//        ConversionServiceFactoryBean ret = new ConversionServiceFactoryBean();
//        ret.setConverters();
//    }
}
