package com.qa.ascendum.pageActions;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.pageLocators.HomePageLocators;

public class ServicePageActions {
	
	BaseActions baseActions = new BaseActions();
	
	public void verifyServicePage() {
	baseActions.clickLinksAndButtons(HomePageLocators.link_contact);
	baseActions.checkAllAnchorTags();
	}

}
