package com.renz.examples.aws.lambda.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by renz on 10/12/16.
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.renz.examples.aws.lambda"})
@EnableJpaRepositories(basePackages = "com.renz.examples.aws.lambda.repository")
@EntityScan(basePackages = {"com.renz.examples.aws.lambda.entity"})
public class CustomerConfig {
}
