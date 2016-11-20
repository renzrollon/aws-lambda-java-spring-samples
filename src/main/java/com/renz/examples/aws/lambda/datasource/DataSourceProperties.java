package com.renz.examples.aws.lambda.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by renz on 10/12/16.
 */
@Component
@ConfigurationProperties(prefix = "database")
@PropertySource("classpath:application.properties")
public class DataSourceProperties {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
