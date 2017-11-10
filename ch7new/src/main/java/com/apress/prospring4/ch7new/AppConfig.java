package com.apress.prospring4.ch7new;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.apress.prospring4.ch7new"})
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
//        BasicDataSource dataSource = new BasicDataSource();
//
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUsername("username");
//        dataSource.setPassword("password");
//        dataSource.setUrl("jdbc:mysql://<host>:<port>/<database>");
//        dataSource.setMaxActive(10);
//        dataSource.setMaxIdle(5);
//        dataSource.setInitialSize(5);
//        dataSource.setValidationQuery("SELECT 1");

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

    @Bean("sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean ret = new LocalSessionFactoryBean();
        ret.setDataSource(dataSource());
        ret.setPackagesToScan("com.apress.prospring4.ch7new");
        return ret;
    }

    @Bean("transactionManager")
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager ret = new HibernateTransactionManager();
        ret.setSessionFactory(sessionFactory().getObject());
        return ret;
    }

}
