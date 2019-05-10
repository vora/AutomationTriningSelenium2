package com.qa.ascendum.pageLocators;

import org.openqa.selenium.By;

public class CareersPageLocators {

	public static final By tabs_cultureAndValues = By.xpath("//li[@id='menu-item-410']/a");
	public static final By tabs_employeeBenefits = By.xpath("//li[@id='menu-item-411']/a");
	public static final By tabs_careersOpenings = By.xpath("//li[@id='menu-item-754']/a");
	public static final By headers_cultureAndValues = By
			.xpath("//div[@class='container']/h1[contains(text(), 'Culture and Values')]");
	public static final By headers_employeeBenefits = By
			.xpath("//div[@class='container']/h1[contains(text(), 'Employee Benefits')]");
	public static final By headers_currentOpenings = By
			.xpath("//h1[@class='elementor-heading-title elementor-size-default']");

}
