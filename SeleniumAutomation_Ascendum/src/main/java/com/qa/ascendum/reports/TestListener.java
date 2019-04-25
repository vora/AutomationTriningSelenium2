package com.qa.ascendum.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.qa.ascendum.base.TestBase;

public class TestListener extends TestBase implements ITestListener {

	ExtentTestManager extentTestManager = new ExtentTestManager();
	ExtentManager extentManager = new ExtentManager();

	public void onStart(ITestContext context) {
		log.info("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " has started ***");
	}

	public void onFinish(ITestContext context) {
		log.info(("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " has ended ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		log.info(("*** Running test method : " + "\""  + result.getMethod().getMethodName() +"\"" + "***"));
		ExtentTestManager.startTest("\""  + result.getMethod().getMethodName() + "\"");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("*** Executed " + "\""  + result.getMethod().getMethodName() + "\""  + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		log.info("*** Test execution " + "\""  + result.getMethod().getMethodName() + "\""  + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		log.info("*** Test " + "\""  + result.getMethod().getMethodName() + "\""  + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("*** Test failed but within percentage % " + "\""  + result.getMethod().getMethodName() + "\"");
	}

}