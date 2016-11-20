package com.renz.examples.aws.lambda.batch;

import com.renz.examples.aws.lambda.entity.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renz on 10/13/16.
 */
@Configuration
public class CustomerStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CustomerReader customerReader;

    @Autowired
    private CustomerProcessor customerProcessor;

    @Autowired
    private CustomerWriter customerWriter;

    @Autowired
    private CustomerListener customerListener;

    private int chunk = 1;

    @Bean
    public Step customerStep() {
        return stepBuilderFactory.get("customerStep")
            .<Customer, Customer>chunk(chunk)
            .faultTolerant()
            .reader(customerReader)
            .processor(customerProcessor)
            .writer(customerWriter)
            .listener(customerListener)
            .build();
    }
}
