package com.qa.ascendum.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.ExcelOperations;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.HomePageActions;

import com.qa.ascendum.pageLocators.HomePageLocators;


public class HomePageTest extends TestBase {

	ExtentReports extentReports;
	ExtentTest extentTest;

	public static final Logger log = Logger.getLogger(HomePageTest.class.getName());

	HomePageActions homepageactions = new HomePageActions();

	@Test
	public void validateHomepage() throws IOException {
		homepageactions.verifyHomePageElements();
		homepageactions.checkLinks();
		homepageactions.searchData();
		homepageactions.mouseHoverServiceLink();
	}

	@Test
	public void searchPhrase() throws IOException {
		homepageactions.enterTextFromExcelInLocator();
		homepageactions.writeToExcel();
	}

	

	@Test
	public void getH3List() throws InterruptedException, IOException {
		homepageactions.getHeadersH3(HomePageLocators.headers);
		homepageactions.hightAllElements();
	}
	

}
