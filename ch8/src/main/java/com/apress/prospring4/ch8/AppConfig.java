package com.apress.prospring4.ch8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.apress.prospring4.ch8"})
@PropertySource(value = "classpath:jdbc.properties")
@EnableTransactionManagement
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

//        EmbeddedDatabaseBuilder builder = new
//                EmbeddedDatabaseBuilder();
//        return builder
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("classpath:META_INF/sql/schema.sql")
//                .addScript("classpath:META-INF/sql/test-data.sq")
//                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean("vendor")
    public HibernateJpaVendorAdapter vendor() {
        HibernateJpaVendorAdapter ret = new HibernateJpaVendorAdapter();
        return ret;
    }

    @Bean("emf")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean ret = new LocalContainerEntityManagerFactoryBean();
        ret.setDataSource(dataSource());
        ret.setJpaVendorAdapter(vendor());
        ret.setPackagesToScan("com.apress.prospring4.ch8");
        return ret;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager ret = new JpaTransactionManager();
        ret.setEntityManagerFactory(emf().getObject());
        return ret;
    }

}
