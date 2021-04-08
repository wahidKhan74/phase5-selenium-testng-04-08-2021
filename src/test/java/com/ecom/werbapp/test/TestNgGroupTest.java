package com.ecom.werbapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

@Test(description="Testng Test Group")
public class TestNgGroupTest {

	final String amazonSiteURL = "https://www.amazon.in/";
	final String facebookSiteURL = "https://www.facebook.com/";

	final String chromeDriverPath = "driver/chromedriver";
	final String firefoxDriverPath = "driver/geckodriver";

	WebDriver driver1;
	WebDriver driver2;

	// Chrome Browser -> group Chrome Test
	@Test(groups = "Chrome", priority = 0)
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver1 = new ChromeDriver();
		driver1.get(amazonSiteURL);
	}

	@Test(groups = "Chrome", dependsOnMethods = "lauchChromeTest", priority = 1)
	void testAmazonHomePageTitle() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expectedTitle, driver1.getTitle());
	}

	@Test(groups = "Chrome", dependsOnMethods = "lauchChromeTest", priority = 2)
	void testAmazonHomePageSourceURL() {
		assertEquals(amazonSiteURL, driver1.getCurrentUrl());
		driver1.close();
	}

	// firefox Browser
	@Test(groups = "FireFox", priority = 0)
	public void lauchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		driver2 = new FirefoxDriver();
		driver2.get(facebookSiteURL);
	}
	
	@Test(groups = "FireFox", dependsOnMethods = "lauchFireFoxTest",priority=1)
	void testToVerifyLogin() {
		driver2.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver2.findElement(By.id("pass")).sendKeys("abc@123");
		driver2.findElement(By.name("login")).click();
		driver2.close();
	}

}
