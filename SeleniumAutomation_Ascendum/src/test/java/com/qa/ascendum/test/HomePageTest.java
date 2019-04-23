package com.qa.ascendum.test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.ExcelOperations;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.HomePageActions;
import com.qa.ascendum.pageLocators.HomePageLocators;

import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

	public static final Logger log = Logger.getLogger(HomePageTest.class.getName());

	HomePageActions homepageactions = new HomePageActions();
	BaseActions baseActions = new BaseActions();
	HomePageLocators homePageLocators = new HomePageLocators();

	@Test(priority = 1)
	public void validateHomepage() {
		homepageactions.verifyHomePageElements();
		//homepageactions.checkLinks();
		homepageactions.searchData();
		homepageactions.mouseHoverServiceLink();
	}
	
	@Test(priority = 2)
	public void searchPhrase()
	{
		homepageactions.enterTextFromExcelInLocator();
	}
	
	//Shows the usage of @Parameter annotation
	@Test(priority = 3)
	@Parameters({"entryTwo"})
	public void enterValueParam(String enterParams) {
		baseActions.clearTextBox(homePageLocators.textBox_search);
		baseActions.searchText(homePageLocators.textBox_search, enterParams);
		baseActions.clickLinksAndButtons(homePageLocators.icon_search);
	}
}
