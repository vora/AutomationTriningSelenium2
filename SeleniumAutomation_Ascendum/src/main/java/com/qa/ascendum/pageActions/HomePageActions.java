package com.qa.ascendum.pageActions;

import org.testng.annotations.DataProvider;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.ExcelOperations;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class HomePageActions extends TestBase {

	BaseActions baseActions = new BaseActions();
	HomePageLocators homePageLocators = new HomePageLocators();
	ExcelOperations excelOperations = new ExcelOperations();

	String enterText = properties.getProperty("enterTextfromConfig");
	String searchText = enterText;

	public void verifyHomePageElements() {
		baseActions.checkIfWebElementIsPresent(homePageLocators.link_services);
		baseActions.checkIfWebElementIsPresent(homePageLocators.link_resources);
		baseActions.checkIfWebElementIsPresent(homePageLocators.link_careers);
		baseActions.checkIfWebElementIsPresent(homePageLocators.link_contact);

	}

	public void checkLinks() {
		baseActions.checkAllAnchorTags();
	}

	public void searchData() {
		baseActions.clearTextBox(homePageLocators.textBox_search);
		baseActions.searchText(homePageLocators.textBox_search, enterText);
		baseActions.clickLinksAndButtons(homePageLocators.icon_search);
		baseActions.retrievedSearchResults(homePageLocators.searcResults, searchText);
	}

	public void mouseHoverServiceLink() {
		baseActions.mousehover(homePageLocators.link_services);
		baseActions.clickLinksAndButtons(homePageLocators.tab_secondItem);
	}

	public void enterTextFromExcelInLocator() {
		try {
			excelOperations.FileInput(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
			excelOperations.fetchWorkBook(excelOperations.workbook);
			excelOperations.fetchWorkSheet(excelOperations.workbook, "SearchText");
			excelOperations.readCellDataFromExcel(5, 1, HomePageLocators.textBox_search);
			excelOperations.closeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// method to show the user of @DataProvider annotation
	@DataProvider(name = "DP_SearchText")
	public Object[][] fetchDataWithDataProvider() {
		return new Object[][] { { "technology" } };
	}
}
