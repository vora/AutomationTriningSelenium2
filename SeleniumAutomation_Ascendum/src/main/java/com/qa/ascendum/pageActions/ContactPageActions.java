package com.qa.ascendum.pageActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.ContactPageLocators;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ContactPageActions extends TestBase {

	ContactPageLocators contactPageLocators = new ContactPageLocators();
	BaseActions baseActions = new BaseActions();

	public void verifyContactPage() throws InterruptedException, IOException {
		baseActions.compareElementText(contactPageLocators.header_contactUS, "CONTACT US");
		enterEnquiryFormText();
		// selectDiscussionCheckBox();

	}

	public void enterEnquiryFormText() {
		baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
		baseActions.enterText(contactPageLocators.text_name, "Rajeshwari");
		baseActions.enterText(contactPageLocators.text_email, "Rajeshwari");
		baseActions.enterText(contactPageLocators.text_company, "Rajeshwari");
		baseActions.enterText(contactPageLocators.text_phoneNo, "Rajeshwari");
		baseActions.enterText(contactPageLocators.text_subject, "Rajeshwari");
		baseActions.enterText(contactPageLocators.text_message, "Rajeshwari");
	}

	public void selectDiscussionCheckBox() throws InterruptedException {
		Thread.sleep(7000);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_enquiry);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_engServices);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_collAndSearch);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_collAndSearch);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_QA);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_demandServices);
		baseActions.checkBoxSelected(contactPageLocators.checkbox_mngmtServices);
	}

}
