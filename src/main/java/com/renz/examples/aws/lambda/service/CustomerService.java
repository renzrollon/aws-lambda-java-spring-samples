package com.renz.examples.aws.lambda.service;

import com.renz.examples.aws.lambda.entity.Customer;
import com.renz.examples.aws.lambda.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renz on 10/12/16.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByName(String name) {
        return customerRepository.findFirstByName(name);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
