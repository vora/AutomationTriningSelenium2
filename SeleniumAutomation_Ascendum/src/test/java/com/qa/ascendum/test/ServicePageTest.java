package com.qa.ascendum.test;

import org.testng.annotations.Test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.ServicePageActions;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ServicePageTest extends TestBase {
	
	ServicePageActions servicePageActions = new ServicePageActions();

	

	@Test()
	public void validateServicePage() {	
		servicePageActions.verifyServicePage();
	}

}
