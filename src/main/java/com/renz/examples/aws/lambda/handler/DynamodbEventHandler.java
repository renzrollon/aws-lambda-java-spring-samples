package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import org.apache.log4j.Logger;


/**
 * Created by renz on 10/17/16.
 */
public class DynamodbEventHandler implements RequestHandler<DynamodbEvent, String> {

    private static final Logger LOGGER_ = Logger.getLogger(DynamodbEventHandler.class);

    @Override
    public String handleRequest(DynamodbEvent dynamodbEvent, Context context) {
        for(DynamodbEvent.DynamodbStreamRecord record : dynamodbEvent.getRecords()) {
            LOGGER_.debug(record.getDynamodb().toString());
        }
        return "Processed records: " + dynamodbEvent.getRecords().size();
    }
}
