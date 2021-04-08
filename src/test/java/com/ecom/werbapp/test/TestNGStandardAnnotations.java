package com.ecom.werbapp.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestNGStandardAnnotations {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" --- Before suite ---");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println(" --- After suite ---");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(" --- Before class ---");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println(" --- After class ---");
	}
	
	@BeforeMethod
	public void setUpBeforEach() {
		System.out.println(" --- Before method ---");
	}
	
	@AfterMethod
	public void tearDownAfterEach() {
		System.out.println(" --- After method ---");
	}
	
	@Test
	public void testOne() {
		System.out.println(" --- Test 1 method is executed ---");
	}
	
	@Test
	public void testTwo() {
		System.out.println(" --- Test 2 method is executed ---");
	}
	
	@Test
	public void testThree() {
		System.out.println(" --- Test 3 method is executed ---");
	}
}
