package com.renz.examples.aws.lambda.batch;

import com.renz.examples.aws.lambda.entity.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by renz on 10/13/16.
 */
@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Override
    public void write(List<? extends Customer> list) throws Exception {
        //empty writer
    }
}
