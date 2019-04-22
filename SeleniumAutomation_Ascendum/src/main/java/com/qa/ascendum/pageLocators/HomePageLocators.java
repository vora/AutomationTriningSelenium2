package com.qa.ascendum.pageLocators;

import org.openqa.selenium.By;

public class HomePageLocators 
	{
		//Locators of Home Page
		public static final By link_services = By.xpath("//li[@class='dropdown']/a[@class='dropdown-toggle']");
		public static final By link_resources = By.xpath("//ul[@class='nav navbar-nav']/li[5]/a");
		public static final By link_careers = By.xpath("//ul[@class='nav navbar-nav']/li[6]/a");
		public static final By link_contact = By.xpath("//ul[@class='nav navbar-nav']/li[7]/a");
		public static final By textBox_search = By.cssSelector("#s");
		public static final By icon_search = By.cssSelector(".search-button");
		public static final By searcResults = By.xpath("//div//h2[contains(text(),'Search Results for ')]");
		public static final By tab_secondItem = By.xpath("//ul[@class='dropdown-menu']/li[2]");

	}

	
