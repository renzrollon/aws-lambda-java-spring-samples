package com.renz.examples.aws.lambda.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renz on 10/12/16.
 */
@Configuration
public class DatabaseConfig {

    public static final String VALIDATION_QUERY = "select 1 from dual";

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(name = "dataSource")
    public javax.sql.DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        DataSource propertyDataSource = dataSourceProperties.getDataSource();
        dataSource.setDriverClassName(propertyDataSource.getDriverClassName());
        dataSource.setUrl(propertyDataSource.getUrl());
        dataSource.setUsername(propertyDataSource.getUsername());
        dataSource.setPassword(propertyDataSource.getPassword());
        dataSource.setValidationQuery(VALIDATION_QUERY);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        return dataSource;
    }
}
