package com.renz.examples.aws.lambda.handler;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by renz on 10/11/16.
 */
public class HelloWorldRequestHandler implements RequestHandler<HelloWorldRequestHandler.User, String> {

    @Override
    public String handleRequest(User user, Context context) {
        return "Hello World! Hi, " + user.getName();
    }

    public static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
