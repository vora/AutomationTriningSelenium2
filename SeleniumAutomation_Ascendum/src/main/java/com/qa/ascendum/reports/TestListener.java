package com.qa.ascendum.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.ExceptionUtil;
import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;

public class TestListener implements ITestListener {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	ExtentTestManager extentTestManager = new ExtentTestManager();
	ExtentManager extentManager = new ExtentManager();
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		log.info("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " has started ***");
	}

	public void onFinish(ITestContext context) {
		log.info(("*** Test Suite : " + "\"" + context.getSuite().getName() + "\"" + " has ended ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		log.info(("*** Running test method : " + "\"" + result.getMethod().getMethodName() + "\"" + "***"));
		ExtentTestManager.startTest("\"" + result.getMethod().getMethodName() + "\"");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("*** Executed " + "\"" + result.getMethod().getMethodName() + "\"" + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		log.info("*** Test execution " + "\"" + result.getMethod().getMethodName() + "\"" + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}	

	public void onTestSkipped(ITestResult result) {
		log.info("*** Test " + "\"" + result.getMethod().getMethodName() + "\"" + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("*** Test failed but within percentage % " + "\"" + result.getMethod().getMethodName() + "\"");
	}

}