package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by renz on 10/12/16.
 */
public class KinesisEventHandler {

    private static final Logger LOGGER_ = Logger.getLogger(KinesisEventHandler.class);

    public void recordHandler(KinesisEvent event, Context context) throws IOException {
        for(KinesisEvent.KinesisEventRecord rec : event.getRecords()) {
            LOGGER_.info(new String(rec.getKinesis().getData().array()));
        }
    }

}
