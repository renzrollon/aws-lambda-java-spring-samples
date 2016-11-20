package com.renz.examples.aws.lambda.batch;

import com.renz.examples.aws.lambda.service.CustomerService;
import com.renz.examples.aws.lambda.entity.Customer;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by renz on 10/13/16.
 */
@Component
public class CustomerReader implements ItemReader<Customer> {

    static final Logger LOGGER_ = Logger.getLogger(CustomerReader.class);

    @Autowired
    private CustomerService customerService;

    private ExecutionContext executionContext;

    private Queue<Customer> customerQueue = new LinkedList<>();

    @BeforeStep
    void retrieveFromContext(StepExecution stepExecution) {

        LOGGER_.debug("Reader: @BeforeStep");
        List<Customer> customerList = customerService.findAll();
        executionContext = stepExecution.getJobExecution().getExecutionContext();

        for(Customer customer : customerList) {
            customerQueue.add(customer);
            executionContext.put(customer.getId().toString(), customer);
        }
    }

    @Override
    public Customer read() throws Exception {
        return customerQueue.poll();
    }
}
