package com.ecom.werbapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertWithFacebookLogin {

	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	// firefox Browser
	@Test(groups = "FireFox", priority = 0)
	public void lauchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@Test(groups = "FireFox", dependsOnMethods = "lauchFireFoxTest", priority = 1)
	void testToVerifyLogin() {
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc@123");
		driver.findElement(By.name("login")).click();
	}
	
	@Test(groups = "FireFox", dependsOnMethods = "testToVerifyLogin", priority = 2)
	void testLoginFailureOutput() {
		WebElement errorbox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div[1]/div[1]"));
		softAssert.assertEquals(errorbox.getText(), "You Can't Use This Feature Right Now");
		softAssert.assertFalse(true);
		driver.close();
	}

}
