package com.qa.ascendum.pageActions;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;

public class SearchPageActions extends TestBase {

	public static final By firstSearchLink = By.xpath("//div[@class='search-line']/h2/a");
	public static final By headerLink = By.xpath("//div[@class='container']/h1");

	BaseActions baseActions = new BaseActions();

	@Test
	// Clicks the first active and valid link
	public void clickSerachLink() {
		// baseActions.checkAllAnchorTags();
		String expectedText = baseActions.retrieveText(firstSearchLink);
		baseActions.clickLinksAndButtons(firstSearchLink);
		baseActions.compareElementText(headerLink, expectedText);
	}

}
