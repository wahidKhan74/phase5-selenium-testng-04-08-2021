package com.ecom.werbapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AmazonNavigationTest {
	
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
	void testMobileNavigationLink() {
		// find mobile link
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		// test evaluation
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	void testTodaysDealNavigationLink() {
		// find todays deal link
		WebElement todayLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		// test evaluation
		assertTrue(todayLink.isDisplayed());
		assertTrue(todayLink.isEnabled());
		todayLink.click();
		String expected = "Amazon.in Today's Deals: Great Savings. Every Day.";
		assertEquals(expected, driver.getTitle());
	}
	

}
