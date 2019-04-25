package com.qa.ascendum.test;

import org.testng.annotations.Test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ServicePageTest {
	
	BaseActions baseActions = new BaseActions();

	@Test(priority = 7)
	public void validateServicePage()
	{
		baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
		baseActions.checkAllAnchorTags();
	}
	
	
}
