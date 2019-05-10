package com.qa.ascendum.pageActions;

import java.util.List;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.ContactPageLocators;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ContactPageActions extends TestBase {

	BaseActions baseActions = new BaseActions();
	
	String generatedEmail = baseActions.createRandomEmail();
	int generatedPhoneNo = baseActions.createRandomePhoneNo();

	public void verifyContactPage() throws InterruptedException, IOException {
		baseActions.compareElementText(ContactPageLocators.header_contactUS, "CONTACT US");
		enterEnquiryFormText();
		// selectCheckBox(ContactPageLocators.checkbox_list);
		baseActions.scrollup();
		selectDiscussionCheckBox();

	}

	public void enterEnquiryFormText() {
		baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
		baseActions.enterText(ContactPageLocators.text_name, "Rajeshwari Prem");
		baseActions.enterText(ContactPageLocators.text_email, generatedEmail);
		isValidEmailId(generatedEmail);
		baseActions.enterText(ContactPageLocators.text_company, "Ascendum Solutions");
		baseActions.enterNo(ContactPageLocators.text_phoneNo, generatedPhoneNo);
		isPhoneNoVlaid(generatedPhoneNo);
		baseActions.enterText(ContactPageLocators.text_subject, "Reg: Automation");
		baseActions.enterText(ContactPageLocators.text_message, "Selenium Automation");
	}

	public void selectDiscussionCheckBox() throws InterruptedException {
		baseActions.waitForExpectedCond(ContactPageLocators.checkbox_enquiry);
		// baseActions.checkElementClickable(ContactPageLocators.checkbox_enquiry);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_enquiry);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_engServices);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_engServices);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_collAndSearch);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_collAndSearch);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_collAndSearch);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_collAndSearch);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_QA);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_QA);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_demandServices);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_demandServices);
		baseActions.checkElementClickable(ContactPageLocators.checkbox_mngmtServices);
		baseActions.selectCheckBox(ContactPageLocators.checkbox_mngmtServices);
	}

	// Regex expression for validating email
	public boolean isValidEmailId(String email) {
		String emailPattern = "[a-zA-Z1-9_]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*";
		Pattern validPattern = Pattern.compile(emailPattern);
		Matcher macther = validPattern.matcher(email);

		if (macther.matches()) {
			Assert.assertTrue(true);
			log.info("Email entered is valid : " + email);
		} else {
			Boolean true1 = baseActions.checkIfWebElementIsPresent(ContactPageLocators.errorText_Email);
			if (true1) {
				String actualText = "Please enter a valid e-mail address";
				baseActions.compareElementText(ContactPageLocators.errorText_Email, actualText);
			}

			Assert.assertTrue(false);

			log.info("Email entered is not valid : " + email);
		}
		return macther.matches();
	}

	// Regex expression to validatre phone number
	public boolean isPhoneNoVlaid(int phoneNo) {
		String newNo = Integer.toString(phoneNo);
		String phoneNoPattern = "^[0-9]{10}$";
		Pattern validPattern = Pattern.compile(phoneNoPattern);
		Matcher macther = validPattern.matcher(newNo);

		if (macther.matches()) {
			Assert.assertTrue(true);
			log.info("Phone No entered is valid : " + phoneNo);
		} else {
			Boolean true1 = baseActions.checkIfWebElementIsPresent(ContactPageLocators.errorText_PhoneNo);
			if (true1) {
				String actualText = "Please enter a valid Phone No";
				baseActions.compareElementText(ContactPageLocators.errorText_PhoneNo, actualText);
			}

			Assert.assertTrue(false);

			log.info("Phone No entered is not valid : " + phoneNo);
		}
		return macther.matches();

	}

	// Select list of checkboxes
	public void selectCheckBox(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		int numberOfElements = elements.size();
		for (int i = 0; i < numberOfElements; i++) {
			elements = driver.findElements(locator);
			elements.get(i).click();
		}
	}

}
