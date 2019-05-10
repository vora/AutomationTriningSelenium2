package com.qa.ascendum.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.ascendum.pageLocators.HomePageLocators;
import com.qa.ascendum.reports.ExtentManager;
import com.qa.ascendum.reports.ExtentTestManager;
import com.qa.ascendum.resources.TestUtil;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public static Properties properties;
	public static BufferedReader reader;
	public static WebDriver driver;
	ITestResult result;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	private static ExtentHtmlReporter extentHtmlReporter;

	public ExtentReports reports;
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;

	protected static final Logger log = Logger.getLogger(TestBase.class.getName());
	protected static final String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\qa\\ascendum\\resources\\config.properties";
	protected static final String log4jpropertyFilepPath = System.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\qa\\ascendum\\resources\\log4j.properties";

	protected TestBase() {

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				PropertyConfigurator.configure(log4jpropertyFilepPath);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	@BeforeClass
	@Parameters({ "browserChrome" })
	public static void Initialize_Browser(String paramBrowser) {

		if (paramBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\ascendum\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Creating the object of " + paramBrowser);
		} else if (paramBrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\ascendum\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Creating the object of " + paramBrowser);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(properties.getProperty("url"));
		log.info("Navigating to " + (properties.getProperty("url")));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}

	@AfterMethod
	public String tearDown(ITestResult result) {
		String path = null;
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				path = "./FailedScreenshots/" + result.getName() + ".png";
				FileUtils.copyFile(source, new File("./FailedScreenshots/" + result.getName() + ".png"));
				log.info("Screenshot was captured for the failed testcase - ");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
		return path;

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}