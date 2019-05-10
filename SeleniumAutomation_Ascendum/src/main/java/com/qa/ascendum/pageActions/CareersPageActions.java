package com.qa.ascendum.pageActions;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.CareersPageLocators;
import com.qa.ascendum.pageLocators.HomePageLocators;
import com.qa.ascendum.resources.ConstantVariables;

public class CareersPageActions extends TestBase {

	BaseActions baseActions = new BaseActions();
	

	public void verifyCareersPage() {
		baseActions.clickLinksAndButtons(HomePageLocators.link_careers);
		baseActions.checkElementClickable(CareersPageLocators.tabs_cultureAndValues);
		baseActions.compareElementText(CareersPageLocators.tabs_cultureAndValues,
				ConstantVariables.cultureAndValues);
				//properties.getProperty("cultureAndValues"));
		baseActions.checkElementClickable(CareersPageLocators.tabs_employeeBenefits);
		baseActions.compareElementText(CareersPageLocators.tabs_cultureAndValues,
				ConstantVariables.employeeAndBenefits);
		baseActions.checkElementClickable(CareersPageLocators.tabs_careersOpenings);
		baseActions.compareElementText(CareersPageLocators.tabs_cultureAndValues,
				ConstantVariables.tabs_currentOpenings);

		baseActions.clickLinksAndButtons(HomePageLocators.link_careers);
		baseActions.clickLinksAndButtons(CareersPageLocators.tabs_cultureAndValues);
		// baseActions.checkElementClickable(CareersPageLocators.headers_cultureAndValues);
		baseActions.compareElementText(CareersPageLocators.tabs_cultureAndValues,
				ConstantVariables.cultureAndValues);

		baseActions.clickLinksAndButtons(HomePageLocators.link_careers);
		baseActions.checkElementClickable(CareersPageLocators.tabs_employeeBenefits);
		baseActions.clickLinksAndButtons(CareersPageLocators.tabs_employeeBenefits);
		baseActions.compareElementText(CareersPageLocators.headers_employeeBenefits,
				ConstantVariables.employeeAndBenefits);

		baseActions.clickLinksAndButtons(HomePageLocators.link_careers);
		baseActions.checkElementClickable(CareersPageLocators.tabs_careersOpenings);
		baseActions.clickLinksAndButtons(CareersPageLocators.tabs_careersOpenings);
		baseActions.compareElementText(CareersPageLocators.headers_currentOpenings,
				ConstantVariables.currentOpenings);

	}

	
	//check all anchor tags
	public void checkAllLinks()
	{
		baseActions.checkAllAnchorTags();
	}
}
