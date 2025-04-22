package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.report.ExtentFactory.getInstance;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest extentTest;
    private static Logger logger = LogManager.getLogger(ExtentReportListener.class);

    @Override
    public void onStart(org.testng.ITestContext context) {
        extentReports = ExtentReportManager.setUpExtentReport(); // Initialize the extent report
    }

    @Override
    public void onTestStart(ITestResult result) {
        this.extentTest = extentReports.createTest(result.getName());
        getInstance().setExtent(extentTest);
        logger.info("Test is added to pool: " + result.getName());// Initialize ExtentTest for the current test
        //getInstance().setExtent(extentTest); // Set it in the factory
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        getInstance().passTest(result.getName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getInstance().failTest(result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getInstance().getExtentTest().log(Status.SKIP, "Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extentReports.flush(); // Finalize and write the report after all tests finish
    }
}
