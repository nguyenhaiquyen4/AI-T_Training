package com.apress.prospring4.ch6.listing6_50;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.apress.prospring4.ch6.listing6_50"})
public class AppConfig {
    @Value("sql/schema.sql")
    private Resource schemaScript;

    @Value("sql/test-data.sql")
    private Resource dataScript;

//    @Value("sql/stored-function.sql")
//    private Resource storefunction;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = createDataSource();
        DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
        return dataSource;
    }

    private DatabasePopulator createDatabasePopulator() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
//        databasePopulator.addScript(schemaScript);
//        databasePopulator.addScript(dataScript);
//        databasePopulator.addScript(storefunction);
        return databasePopulator;
    }

    private SimpleDriverDataSource createDataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
//        simpleDriverDataSource.setDriverClass(org.h2.Driver.class);
//        simpleDriverDataSource.setUrl("jdbc:h2:target/database/example");
//        simpleDriverDataSource.setUsername("");
//        simpleDriverDataSource.setPassword("");

        simpleDriverDataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        simpleDriverDataSource.setUrl("jdbc:mysql://localhost:3306/prospring4");
        simpleDriverDataSource.setUsername("prospring4");
        simpleDriverDataSource.setPassword("prospring4");

        return simpleDriverDataSource;
    }
}
