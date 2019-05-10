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
	BaseActions baseActions = new BaseActions();
	ExcelOperations excelOperations = new ExcelOperations();

	@Test
	public void validateHomepage() throws IOException {
		homepageactions.verifyHomePageElements();
		// homepageactions.checkLinks();
		homepageactions.searchData();
		homepageactions.mouseHoverServiceLink();
	}

	@Test
	public void searchPhrase() throws IOException {
		homepageactions.enterTextFromExcelInLocator();
		homepageactions.writeToExcel();
	}

	// Shows the usage of @Parameter annotation
	@Test
	@Parameters({ "entryTwo" })
	public void enterValueParam(String enterParams) {
		baseActions.clearTextBox(HomePageLocators.textBox_search);
		baseActions.enterText(HomePageLocators.textBox_search, enterParams);
		baseActions.clickLinksAndButtons(HomePageLocators.icon_search);
		// searchPageActions.clickSerachLink();
		baseActions.retrieveText(HomePageLocators.link_contact);
	}

	// Shows the usage of @DataProvider annotation
	@Test(dataProvider = "DP_SearchText", dataProviderClass = com.qa.ascendum.pageActions.HomePageActions.class)
	public void useDataProviderValue(String enterText) {
		baseActions.clearTextBox(HomePageLocators.textBox_search);
		baseActions.enterText(HomePageLocators.textBox_search, enterText);
	}


	@Test
	public void getH3List() throws InterruptedException, IOException {
		homepageactions.getHeadersH3(HomePageLocators.headers);
		homepageactions.hightAllElements();
	}
	

}
