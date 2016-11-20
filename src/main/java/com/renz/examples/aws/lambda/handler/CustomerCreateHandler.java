package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.renz.examples.aws.lambda.service.CustomerService;
import com.renz.examples.aws.lambda.config.CustomerConfig;
import com.renz.examples.aws.lambda.entity.Customer;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by renz on 10/12/16.
 */
public class CustomerCreateHandler implements RequestHandler<Customer, Customer> {

    private static final Logger LOGGER_ = Logger.getLogger(CustomerCreateHandler.class);

    private ApplicationContext applicationContext;

    private CustomerService customerService;

    public CustomerCreateHandler() {
        applicationContext = new AnnotationConfigApplicationContext(CustomerConfig.class);
        customerService = applicationContext.getBean(CustomerService.class);
    }

    @Override
    public Customer handleRequest(Customer customer, Context context) {
        LOGGER_.debug("Saving customer with name: " + customer.getName());
        Customer savedCustomer = customerService.save(customer);
        LOGGER_.debug("Successfully saved customer: " + savedCustomer.getId());
        return savedCustomer;
    }
}
