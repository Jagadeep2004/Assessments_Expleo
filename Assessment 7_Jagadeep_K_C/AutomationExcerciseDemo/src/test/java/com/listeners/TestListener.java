package com.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class TestListener implements ITestListener {

    private static final Logger log = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("STARTED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("FAILED: " + result.getMethod().getMethodName());
        log.error("Reason: ", result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("===== TEST SUITE STARTED: " + context.getName() + " =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("===== TEST SUITE FINISHED: " + context.getName() + " =====");
    }
}
