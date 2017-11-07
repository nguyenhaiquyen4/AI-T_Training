package com.apress.prospring4.ch4.listing4_48;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import com.apress.prospring4.ch4.listing4_42.*;

@Configuration
//@ImportResource(value = "classpath:META-INF/spring/app-context-xml.xml")
@PropertySource(value = "classpath:labels.properties")
//@ComponentScan(basePackages = {"com.apress.prospring4.ch4.listing4_46"})
public class AppConfig {
    @Autowired
    Environment env;

    @Bean
    @Lazy(value = true)
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}