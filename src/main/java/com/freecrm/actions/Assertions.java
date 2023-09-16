package com.freecrm.actions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions {
	
	private SoftAssert softAssert = null;
	
	public Assertions() {
		softAssert = new SoftAssert();
	}
	
	public void assertEquals(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Assertion failed");
		}
		System.out.println("After Asserting");
	}
	
	public void assertNotEquals(String actual, String expected) {
		Assert.assertNotEquals(actual, expected);
	}
	
	public boolean checkVisible(WebElement elem) {
		Assert.assertTrue(elem.isDisplayed());
		return true;
	}
	
	public void assertEqualsSA(String actual, String expected) {
		softAssert.assertEquals(actual, expected);
		System.out.println("After Asserting");
	}
	
	public void assertNotEuqalsSA(String actual, String expected) {
		softAssert.assertNotEquals(actual, expected);
	}
	
	public void assertAll() {
		softAssert.assertAll();
	}

}
