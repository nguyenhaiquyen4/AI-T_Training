package com.apress.prospring4.ch9;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import javax.transaction.SystemException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.apress.prospring4.ch9")
@EnableJpaRepositories
@PropertySource(value = "classpath:jdbc.properties")
public class AppConfig {
    @Autowired
    Environment env;

    @Value("${jdbca.password}")
    private String passworda;

    @Value("${jdbca.username}")
    private String usernamea;

    @Value("${jdbca.database}")
    private String databaseNamea;

    @Value("${jdbca.driverClassName}")
    private String driverClassNamea;

    @Value("${jdbca.unique}")
    private String uniqueResourceNamea;

    @Value("${jdbcb.password}")
    private String passwordb;

    @Value("${jdbcb.username}")
    private String usernameb;

    @Value("${jdbcb.database}")
    private String databaseNameb;

    @Value("${jdbcb.driverClassName}")
    private String driverClassNameb;

    @Value("${jdbcb.unique}")
    private String uniqueResourceNameb;

    @Bean(value = "dataSourceA", initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceA() {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSourceClassName(driverClassNamea);
        ds.setUniqueResourceName(uniqueResourceNamea);
        ds.setPoolSize(1);
        Properties xaProperties = new Properties();
        xaProperties.setProperty("databaseName", databaseNamea);
        xaProperties.setProperty("user", usernamea);
        xaProperties.setProperty("password", passworda);
        ds.setXaProperties(xaProperties);
        return ds;
    }

    @Bean(value = "dataSourceB", initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceB() {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSourceClassName(driverClassNameb);
        ds.setUniqueResourceName(uniqueResourceNameb);
        ds.setPoolSize(1);
        Properties xaProperties = new Properties();
        xaProperties.setProperty("databaseName", databaseNameb);
        xaProperties.setProperty("user", usernameb);
        xaProperties.setProperty("password", passwordb);
        ds.setXaProperties(xaProperties);
        return ds;
    }

    @Bean(value = "emfBase")
    @Scope("prototype")
    public LocalContainerEntityManagerFactoryBean emfBase() {
        LocalContainerEntityManagerFactoryBean ret = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        ret.setPackagesToScan("com.apress.prospring4.ch9");
        ret.setJpaVendorAdapter(vendor);
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");
        jpaProperties.setProperty("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.max_fetch_depth", "3");
        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        jpaProperties.setProperty("hibernate.jdbc.batch_size", "10");
        jpaProperties.setProperty("com.atomikos.icatch.service","com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        ret.setJpaProperties(jpaProperties);
        return ret;
    }

    @Bean("emfA")
    public LocalContainerEntityManagerFactoryBean emfA() {
//        LocalContainerEntityManagerFactoryBean ret = emfBase();
        LocalContainerEntityManagerFactoryBean ret = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        ret.setPackagesToScan("com.apress.prospring4.ch9");
        ret.setJpaVendorAdapter(vendor);
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");
        jpaProperties.setProperty("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.max_fetch_depth", "3");
        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        jpaProperties.setProperty("hibernate.jdbc.batch_size", "10");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        jpaProperties.setProperty("com.atomikos.icatch.service","com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        ret.setJpaProperties(jpaProperties);
        ret.setDataSource(dataSourceA());
        ret.setPersistenceUnitName("emfA");
        return ret;
    }

    @Bean("emfB")
    public LocalContainerEntityManagerFactoryBean emfB() {
//        LocalContainerEntityManagerFactoryBean ret = emfBase();
        LocalContainerEntityManagerFactoryBean ret = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        ret.setPackagesToScan("com.apress.prospring4.ch9");
        ret.setJpaVendorAdapter(vendor);
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");
        jpaProperties.setProperty("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");
        jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.setProperty("hibernate.max_fetch_depth", "3");
        jpaProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        jpaProperties.setProperty("hibernate.jdbc.batch_size", "10");
        jpaProperties.setProperty("hibernate.show_sql", "true");
        jpaProperties.setProperty("com.atomikos.icatch.service","com.atomikos.icatch.standalone.UserTransactionServiceFactory");
        ret.setJpaProperties(jpaProperties);
        ret.setDataSource(dataSourceB());
        ret.setPersistenceUnitName("emfB");
        return ret;
    }

    @Bean(value = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager() {
        UserTransactionManager ret = new UserTransactionManager();
        ret.setForceShutdown(true);
        return ret;
    }

    @Bean("atomikosUserTransaction")
    public UserTransactionImp atomikosUserTransaction() {
        UserTransactionImp ret = new UserTransactionImp();
        try {
            ret.setTransactionTimeout(300);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Bean("transactionManager")
    public JtaTransactionManager transactionManager() {
        JtaTransactionManager ret = new JtaTransactionManager();
        ret.setTransactionManager(atomikosTransactionManager());
        ret.setUserTransaction(atomikosUserTransaction());
        return ret;
    }
}
