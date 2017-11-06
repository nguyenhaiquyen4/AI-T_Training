package com.apress.prospring4.ch3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OracleConfig {
    @Bean
    public Oracle BookwormOracle() {
        return new BookwormOracle();
    }
}
