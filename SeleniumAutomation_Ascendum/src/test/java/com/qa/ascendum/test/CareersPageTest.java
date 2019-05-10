package com.qa.ascendum.test;

import org.testng.annotations.Test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.CareersPageActions;
import com.qa.ascendum.pageLocators.CareersPageLocators;
import com.qa.ascendum.pageLocators.ContactPageLocators;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class CareersPageTest extends TestBase {

	CareersPageActions careersPageActions = new CareersPageActions();

	@Test
	public void validateCareersPage() {
		careersPageActions.verifyCareersPage();
		careersPageActions.checkAllLinks();
		
	}

}
