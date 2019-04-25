package com.qa.ascendum.pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPageLocators {
	public static final By header_contactUS = By.xpath("//div[@class='container']/h1");
	public static final By text_name = By.cssSelector("#contactName");
	public static final By text_email = By.cssSelector("#businessEmail");
	public static final By text_company = By.cssSelector("#contactOrg");
	public static final By text_phoneNo = By.cssSelector("#businessPhone");
	public static final By text_subject = By.cssSelector("#subject");
	public static final By text_message = By.cssSelector("#additionalInfo");
	public static final By checkbox_enquiry = By.xpath("//div[@class='row'][1]/input[@class='discussOn']");
	public static final By checkbox_engServices = By.xpath("//div[@class='row'][2]/input[@class='discussOn']");
	public static final By checkbox_collAndSearch = By.xpath("//div[@class='row'][3]/input[@class='discussOn']");
	public static final By checkbox_QA = By.xpath("//div[@class='row'][4]/input[@class='discussOn']");
	public static final By checkbox_demandServices = By.xpath("//div[@class='row'][5]/input[@class='discussOn']");
	public static final By checkbox_mngmtServices = By.xpath("//div[@class='row'][6]/input[@class='discussOn']");

}
