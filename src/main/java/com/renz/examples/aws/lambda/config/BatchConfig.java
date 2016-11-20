package com.renz.examples.aws.lambda.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by renz on 10/13/16.
 */
@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.renz.examples.aws.lambda"})
@EnableJpaRepositories(basePackages = "com.renz.examples.aws.lambda.repository")
@EntityScan(basePackages = {"com.renz.examples.aws.lambda.entity"})
public class BatchConfig extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private Step customerStep;

    @Bean
    public Job customerJob() {
        return jobBuilderFactory.get("customerJob")
            .incrementer(new RunIdIncrementer())
            .start(customerStep)
                .on("*")
                .end()
            .end()
            .build();
    }
}
