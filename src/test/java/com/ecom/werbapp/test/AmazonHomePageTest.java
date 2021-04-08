package com.ecom.werbapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AmazonHomePageTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeMethod
	public void lauchBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterMethod
	public void cloaseBrowser() {
		driver.close();
	}

	@Test
	void testAmazonHomePageTitle() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expectedTitle, driver.getTitle());
	}
	
	@Test
	void testAmazonHomePageSourceURL() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}

}
