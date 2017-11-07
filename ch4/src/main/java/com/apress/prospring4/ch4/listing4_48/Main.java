package com.apress.prospring4.ch4.listing4_48;

import com.apress.prospring4.ch4.listing4_42.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer renderer =
                ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
