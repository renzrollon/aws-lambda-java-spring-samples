package com.renz.examples.aws.lambda.repository;

import com.renz.examples.aws.lambda.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by renz on 10/12/16.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findFirstByName(String name);
    List<Customer> findAll();
}
