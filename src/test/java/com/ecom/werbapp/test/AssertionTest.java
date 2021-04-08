package com.ecom.werbapp.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
  
	// hard assert : Hard Assert throws an AssertException immediately when an assert statement 
	// fails and test suite continues with next @Test
	@Test
	public void hardAssert() {
		System.out.println("--- Hard Assert Method was started . ---");
		// assertEquals(true, false);
		 assertTrue(true);  // AssertionError
		System.out.println("--- Hard Assert Method was executed .---");
	}
	
	
	// soft assert :- Soft Assert collects errors during @Test. 
	// Soft Assert does not throw an exception when an assert fails 
	@Test
	public void softAssert() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("--- Soft Assert Method was started . ---");
		// softAssert.assertEquals(true, false); 
		softAssert.assertTrue(false);
		System.out.println("--- Soft Assert Method was executed .---");
	}
}
