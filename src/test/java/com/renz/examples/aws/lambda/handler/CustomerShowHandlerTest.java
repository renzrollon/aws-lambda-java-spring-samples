package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.renz.examples.aws.lambda.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by renz on 10/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerShowHandlerTest {

    private CustomerShowHandler handler;

    @Before
    public void setup() {
        handler = new CustomerShowHandler();
    }

    @Test //Connects to RDS
    public void handleRequest() {
        Customer request = new Customer();
        request.setName("new customer");
        Customer response = handler.handleRequest(request, mock(Context.class));

        assertThat(response.getName(), equalTo("new customer"));
        assertNotNull(response.getId());
    }
}
