package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * Created by renz on 10/11/16.
 */
public class HelloWorldHandler {

    public String greet(String name, Context context) {
        return "Hello World! Hi, " + name;
    }
}
