package com.qa.ascendum.test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.ExcelOperations;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.HomePageActions;
import com.qa.ascendum.pageLocators.HomePageLocators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

	public static final Logger log = Logger.getLogger(HomePageTest.class.getName());

	HomePageActions homepageactions = new HomePageActions();
	BaseActions baseActions = new BaseActions();
	HomePageLocators homePageLocators = new HomePageLocators();
	ExcelOperations excelOperations = new ExcelOperations();

	@Test(priority = 1)
	public void validateHomepage() {
		homepageactions.verifyHomePageElements();
		homepageactions.checkLinks();
		homepageactions.searchData();
		homepageactions.mouseHoverServiceLink();
	}

	@Test(priority = 2)
	public void searchPhrase() {
		homepageactions.enterTextFromExcelInLocator();
	}

	// Shows the usage of @Parameter annotation
	 @Test(priority = 3)
	@Parameters({ "entryTwo" })
	public void enterValueParam(String enterParams) {
		baseActions.clearTextBox(homePageLocators.textBox_search);
		baseActions.searchText(homePageLocators.textBox_search, enterParams);
		baseActions.clickLinksAndButtons(homePageLocators.icon_search);
	}

	// Shows the usage of @DataProvider annotation
	 @Test(priority = 3, dataProvider = "DP_SearchText", dataProviderClass = com.qa.ascendum.pageActions.HomePageActions.class)
	public void testMethod(String enterText) {
		baseActions.clearTextBox(homePageLocators.textBox_search);
		baseActions.searchText(homePageLocators.textBox_search, enterText);
	}

	@Test
	public void write() throws IOException {
		String element = driver.findElement(HomePageLocators.link_careers).getText();
		excelOperations.FileInput(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
		excelOperations.fetchWorkBook(excelOperations.fis);
		excelOperations.fetchWorkSheet(excelOperations.workbook, "WriteToExcel");

		excelOperations.row = excelOperations.sheet.createRow(5);
		excelOperations.cell = excelOperations.row.createCell(7);
		excelOperations.cell.setCellType(excelOperations.cell.CELL_TYPE_STRING);
		excelOperations.cell.setCellValue(element);
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
		excelOperations.workbook.write(fos);
	}
}
