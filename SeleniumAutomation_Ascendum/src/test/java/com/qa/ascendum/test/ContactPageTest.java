package com.qa.ascendum.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.ContactPageActions;
import com.qa.ascendum.pageLocators.ContactPageLocators;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ContactPageTest extends TestBase {

	ContactPageActions contactPageActions = new ContactPageActions();

	BaseActions baseActions = new BaseActions();

	@Test
	public void verifyContact() throws InterruptedException, IOException {
		contactPageActions.verifyContactPage();
	}

}
