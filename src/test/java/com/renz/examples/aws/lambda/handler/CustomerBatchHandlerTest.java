package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.ExitStatus;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by renz on 10/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerBatchHandlerTest {

    private CustomerBatchHandler handler;

    @Before
    public void setup() {
        handler = new CustomerBatchHandler();
    }

    @Test //Connects to RDS
    public void handleRequest() {
        String response = handler.handleRequest("paramsString", mock(Context.class));

        assertThat(response, equalTo(ExitStatus.COMPLETED.getExitCode()));
    }
}
