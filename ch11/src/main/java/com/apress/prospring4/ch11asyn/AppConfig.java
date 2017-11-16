package com.apress.prospring4.ch11asyn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.apress.prospring4.ch11asyn")
@EnableTransactionManagement
public class AppConfig {
}
