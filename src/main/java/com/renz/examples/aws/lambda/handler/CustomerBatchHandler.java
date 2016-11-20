package com.renz.examples.aws.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.renz.examples.aws.lambda.config.BatchConfig;
import org.apache.log4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by renz on 10/13/16.
 */
public class CustomerBatchHandler implements RequestHandler<String, String> {

    static final Logger LOGGER = Logger.getLogger(CustomerBatchHandler.class);

    private ApplicationContext applicationContext;

    private JobLauncher jobLauncher;

    private Job job;

    public CustomerBatchHandler() {
        applicationContext = new AnnotationConfigApplicationContext(BatchConfig.class);
        jobLauncher = applicationContext.getBean(JobLauncher.class);
        job = applicationContext.getBean(Job.class);
    }

    @Override
    public String handleRequest(String params, Context context) {
        try {
            JobExecution jobExecution = jobLauncher.run(job, createJobParameters(params));
            return jobExecution.getExitStatus().getExitCode();
        } catch (JobExecutionException e) {
            LOGGER.error("Error running job", e);
            return e.getMessage();
        }
    }

    private JobParameters createJobParameters(String params) {
        //TODO: parse params
        return new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis()).toJobParameters();
    }
}
