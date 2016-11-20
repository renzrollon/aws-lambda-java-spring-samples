package com.renz.examples.aws.lambda.batch;

import com.renz.examples.aws.lambda.entity.Customer;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by renz on 10/13/16.
 */
@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    static final Logger LOGGER_ = Logger.getLogger(CustomerReader.class);

    @Override
    public Customer process(Customer customer) throws Exception {
        LOGGER_.debug("Processing customer name: " + customer.getName());
        return customer;
    }
}
