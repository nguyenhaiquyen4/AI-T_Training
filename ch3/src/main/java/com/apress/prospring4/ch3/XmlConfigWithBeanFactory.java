package com.apress.prospring4.ch3;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
//        rdr.loadBeanDefinitions(new
//                ClassPathResource("META-INF/spring/xml-bean-factory-config.xml"));
//        Oracle oracle = (Oracle) factory.getBean("oracle");
//        System.out.println(oracle.defineMeaningOfLife());

        ApplicationContext ctx = new AnnotationConfigApplicationContext(OracleConfig.class);

        Oracle helloWorld = ctx.getBean(Oracle.class);
        System.out.println(helloWorld.defineMeaningOfLife());
    }
}