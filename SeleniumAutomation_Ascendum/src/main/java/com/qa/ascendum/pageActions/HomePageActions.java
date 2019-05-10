package com.qa.ascendum.pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.ExcelOperations;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.HomePageLocators;
import com.qa.ascendum.pageLocators.ServicesPageLocators;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class HomePageActions extends TestBase {

	BaseActions baseActions = new BaseActions();
	ExcelOperations excelOperations = new ExcelOperations();
	ServicesPageLocators servicesPageLocators = new ServicesPageLocators();

	String enterText = properties.getProperty("enterTextfromConfig");
	String searchText = enterText;

	public void verifyHomePageElements() {
		baseActions.checkIfWebElementIsPresent(HomePageLocators.link_services);
		baseActions.checkIfWebElementIsPresent(HomePageLocators.link_resources);
		baseActions.checkIfWebElementIsPresent(HomePageLocators.link_careers);
		baseActions.checkIfWebElementIsPresent(HomePageLocators.link_contact);

	}

	public void checkLinks() {
		baseActions.checkAllAnchorTags();
	}

	public void searchData() {
		baseActions.clearTextBox(HomePageLocators.textBox_search);
		baseActions.enterText(HomePageLocators.textBox_search, enterText);
		baseActions.clickLinksAndButtons(HomePageLocators.icon_search);
		baseActions.retrievedSearchResults(HomePageLocators.searcResults, searchText);
	}

	public void mouseHoverServiceLink() {
		baseActions.mousehover(HomePageLocators.link_services);
		baseActions.clickLinksAndButtons(HomePageLocators.tab_secondItem);
	}
	
	public void hightAllElements() throws IOException {
		baseActions.highlightElement(HomePageLocators.link_services);
		baseActions.captureScreen("highlightServices");
		baseActions.highlightElement(HomePageLocators.link_resources);
		baseActions.captureScreen("highlightResources");
		baseActions.highlightElement(HomePageLocators.link_careers);
		baseActions.captureScreen("highlightCareers");
		baseActions.highlightElement(HomePageLocators.link_contact);
		baseActions.captureScreen("highlightContact");
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

	// Gets the list of the h3 in the container with class = inner
	public void getHeadersH3(By locator) throws InterruptedException, IOException {
		String expected = properties.getProperty("headerOnPage");
		List<WebElement> h3List = driver.findElements(locator);
		for (WebElement h3 : h3List) {
			try {
				if ((h3.getText()).equals(properties.getProperty("headerTobeValidated"))) {
					clickLinkByHref(properties.getProperty("navigateToUrl"));
					String actual = baseActions.retrieveText(ServicesPageLocators.header_intial);
					Assert.assertEquals(actual, expected);

				} else {
					log.info("System has not navigated to the specified url: "
							+ properties.getProperty("navigateToUrl"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void clickLinkByHref(String href) throws IOException {
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();
		while (i.hasNext()) {
			WebElement anchor = i.next();
			if (anchor.getAttribute("href").contains(href)) {
				log.info("The page for which system has navigated is " + anchor.getAttribute("href"));
				driver.navigate().to(anchor.getAttribute("href"));
				break;
			}
		}
	}
	
	
	//Excel Operations
	public void writeToExcel() throws IOException {
		String element = driver.findElement(HomePageLocators.link_careers).getText();
		excelOperations.FileInput(System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
		excelOperations.fetchWorkBook(excelOperations.fis);
		excelOperations.fetchWorkSheet(excelOperations.workbook, "WriteToExcel");

		excelOperations.row = excelOperations.sheet.createRow(5);
		excelOperations.cell = excelOperations.row.createCell(7);
		excelOperations.cell.setCellType(excelOperations.cell.CELL_TYPE_STRING);
		excelOperations.cell.setCellValue(element);
		FileOutputStream fos = new FileOutputStream(
				System.getProperty("user.dir") + properties.getProperty("excelFilePath"));
		excelOperations.workbook.write(fos);
	}
	
	
	
	@Parameters({ "entryTwo" })
	public void enterValueParam(String enterParams) {
		baseActions.clearTextBox(HomePageLocators.textBox_search);
		baseActions.enterText(HomePageLocators.textBox_search, enterParams);
		baseActions.clickLinksAndButtons(HomePageLocators.icon_search);
		// searchPageActions.clickSerachLink();
		baseActions.retrieveText(HomePageLocators.link_contact);
	
		
		//
		baseActions.clearTextBox(HomePageLocators.textBox_search);
		baseActions.enterText(HomePageLocators.textBox_search, enterText);
	}

}
