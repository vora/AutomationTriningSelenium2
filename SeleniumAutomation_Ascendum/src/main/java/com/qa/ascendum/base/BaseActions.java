package com.qa.ascendum.base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

public class BaseActions extends TestBase {

	String url = "";
	String homePage = "https://ascendum.com";
	String link = "";

	// DateTime
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	// Verify if the element is present and prints the text of the element
	// accordingly
	public void checkIfWebElementIsPresent(By locator) {
		WebElement element = driver.findElement(locator);
		final Boolean checkElementPresent = element.isDisplayed();
		if (checkElementPresent.equals(true)) {
			log.info("The webelement : " + retrieveText(locator) + " is present on the web page.");
		} else {
			log.info("The welelment : " + "" + retrieveText(locator) + "\""
					+ " is miising - There might be some error in loading of the page. Please refresh and try again.");
		}
	}

	// Method to get all the anchor tags in a list
	public void checkAllAnchorTags() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = allLinks.iterator();
		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.equals("")) {
				continue;
			}

			if (!url.startsWith(homePage)) {
				// log.info(url + " - URL belongs to another domain. Hence, skipping it.");
				continue;
			}

			validateUrl(url);
		}
	}

	// verify if the url is valid or broken
	public void validateUrl(String link) {
		try {
			URL url = new URL(link);

			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();

			if (httpConn.getResponseCode() == 200) {
				log.info(link + " " + httpConn.getResponseMessage() + ". The url is valid");
			}

			this.checkFor200Status(httpConn.getResponseCode());

			if (httpConn.getResponseCode() >= 300) {
				// log.info(link + " - " + httpConn.getResponseMessage() + ". The URL is being
				// redirected");
			}

			if (httpConn.getResponseCode() >= 400) {
				// log.info(link + " - " + httpConn.getResponseMessage() + ". The URL is either
				// broken or not configured");
			}

			if (httpConn.getResponseCode() >= 500) {
				// log.info(link + " - " + httpConn.getResponseMessage() + ". There are server
				// errors");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to validate the http - status code
	public void checkFor200Status(int statusCode) {
		switch (statusCode) {
		case 201: {
			log.info(link + " - Created");
		}
		case 202: {
			log.info(link + " - Accepted");
		}
		case 203: {
			log.info(link + " - Non-Authoritative Information");
		}
		case 204: {
			log.info(link + " - No Content");
		}
		case 205: {
			log.info(link + " - Reset Content");
		}
		case 206: {
			log.info(link + " - Partial Content");
		}
		case 207: {
			log.info(link + " - Multi Status (WebDAV)");
		}
		case 208: {
			log.info(link + " - Non-Authoritative Information (WebDAV)");
		}
		case 226: {
			log.info(link + " - IM Used");
		}
		}

	}

	// Method to fetch the retrieved text
	public String retrieveText(By locator) {
		WebElement element = driver.findElement(locator);
		final String elementText = element.getText();
		return elementText;
	}

	// Method to enter text in the search text box
	public String searchText(By locator, String enterText) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(enterText);
		return enterText;
	}

	// Method to click on an element based on the element locator
	public void clickLinksAndButtons(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	// Method to validate the search results (if entered text and retrieved text are
	// same)
	public void retrievedSearchResults(By locator, String searchText) {
		WebElement element = driver.findElement(locator);
		String retrievedText = element.getText();
		String s = StringUtils.substringBetween(retrievedText, "'", "'");
		String expected = searchText;
		Assert.assertEquals(expected, s);
	}

	// Mouse over on the webElement
	public void mousehover(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	// enters a text in a text box
	public void enterText(By locator, String keysToSend) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(keysToSend);
	}

	// clears the textBox
	public void clearTextBox(By locator) {
		WebElement element = driver.findElement(locator);
		element.clear();
	}

	// method to select the checkbox
	public void selectCheckBox(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	// method to deselect the checkbox
	public void deSelectCheckBox(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	// method to check if a checkbox is selected or not
	public void checkBoxSelected(By locator) {
		WebElement element = driver.findElement(locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	// selects a value from the dropdown based on the index provided
	public void selectValueByIndex(By locator, int indexNo) {
		Select select = new Select(driver.findElement(locator));
		select.selectByIndex(indexNo);
	}

	// selects a value from the dropdown based on the inner value provided
	public void selectValueByName(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByValue(value);
	}

	// selects a value from the dropdown based on the text visible
	public void selectValueByVisibleText(By locator, String visibleText) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(visibleText);
	}

	// Captures screen shot at a specified folder with name entered in the
	// parameters
	public static String captureScreen(WebDriver driver, String screenName) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "//Test-ScreenShots//" + screenName + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	// Compares the text of the lement with the expected text
	public void compareElementText(By locator, String expectedString) {
		WebElement text = driver.findElement(locator);
		if ((text.getText()).equals(expectedString)) {
			String actualString = retrieveText(locator);
			Assert.assertEquals(actualString, expectedString);
		}
	}

}
