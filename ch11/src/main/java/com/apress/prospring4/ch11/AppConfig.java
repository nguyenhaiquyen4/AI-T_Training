package com.apress.prospring4.ch11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.apress.prospring4.ch11")
@EnableJpaRepositories
@PropertySource(value = "classpath:jdbc.properties")
@EnableScheduling
public class AppConfig {
    @Autowired
    Environment env;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager ret = new JpaTransactionManager();
        ret.setEntityManagerFactory(emf().getObject());
        return ret;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean ret = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        ret.setPackagesToScan("com.apress.prospring4.ch11");
        ret.setJpaVendorAdapter(vendor);
        ret.setDataSource(dataSource());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.max_fetch_depth", "3");
        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        jpaProperties.setProperty("hibernate.jdbc.batch_size", "10");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        ret.setJpaProperties(jpaProperties);
        return ret;
    }

}
