package com.apress.prospring4.ch5bis.listing5_69;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.apress.prospring4.ch5bis.listing5_69"})
public class AppConfig {
}
