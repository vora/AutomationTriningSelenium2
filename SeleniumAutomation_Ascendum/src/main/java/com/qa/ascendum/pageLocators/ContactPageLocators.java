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
	public static final By checkbox_enquiry = By.xpath("//div[@class='row'][1]/input[@class='discussOn' and contains(text(), 'General Enquiry']");
	public static final By checkbox_engServices = By.xpath("//div[@class='row'][2]/input[@class='discussOn']");
	public static final By checkbox_collAndSearch = By.xpath("//div[@class='row'][3]/input[@class='discussOn']");
	public static final By checkbox_QA = By.xpath("//div[@class='row'][4]/input[@class='discussOn']");
	public static final By checkbox_demandServices = By.xpath("//div[@class='row'][5]/input[@class='discussOn']");
	public static final By checkbox_mngmtServices = By.xpath("//div[@class='row'][6]/input[@class='discussOn']");
	public static final By errorText_Email = By.xpath("//div/div[@class='row pb20'][2]/span[@class='error']");
	public static final By errorText_PhoneNo = By.xpath("//div/div[@class='row pb20'][4]/span[@class='error']");
	
	public static final By checkbox_list = By.xpath("//input[@type='checkbox']");
	
	

	
//	public static final By checkbox_enquiry = By.cssSelector(".row:nth-child(0) > .discussOn");
//	public static final By checkbox_engServices = By.cssSelector(".row:nth-child(1) > .discussOn");
//	public static final By checkbox_collAndSearch = By.cssSelector(".row:nth-child(2) > .discussOn");
//	public static final By checkbox_QA = By.cssSelector(".row:nth-child(3) > .discussOn");
//	public static final By checkbox_demandServices = By.cssSelector(".row:nth-child(4) > .discussOn");
//	public static final By checkbox_mngmtServices = By.cssSelector(".row:nth-child(5) > .discussOn");
	
}
