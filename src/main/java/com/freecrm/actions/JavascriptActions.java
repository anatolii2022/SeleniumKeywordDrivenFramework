package com.freecrm.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.freecrm.engine.SingletonDriver;

public class JavascriptActions {
	
	/**
	 * execute - generic method to execute a non-parameterized JS command
	 * @ param command
	 */
	public static void execute(String command) {
		WebDriver driver = SingletonDriver.getInstance().getDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(command);
	}
	
	/*
	 * execute - overloaded method to execute a JavaScript command on WebElement
	 * 
	 * @param command
	 * @param element
	 */
	
	public static void execute(String command, WebElement element) {
		WebDriver driver = SingletonDriver.getInstance().getDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(command, element);
	}
	
	/*
	 * click - method to execute a JavaScript click event
	 * 
	 * @param element
	 */
	
	public static void click(WebElement element) {
		WebDriver driver = SingletonDriver.getInstance().getDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click;", element);
	}
	
	/*
	 * click - overloaded method to execute a JavaScript click event using By
	 * 
	 * @param by
	 */
	
	public static void click(By by) {
		WebDriver driver = SingletonDriver.getInstance().getDriver();
		WebElement element = driver.findElement(by);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click;", element);
	}
	
	/*
	 * sendKeys - method to execute a JavaScript value event
	 * 
	 * @param keys
	 * @param element
	 */
	
	public static void sendKeys(String value, WebElement element) {
		WebDriver driver = SingletonDriver.getInstance().getDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].value='" + value + "';", element);
	}
	
	/*
	 * 
	 * isPageLoaded - method to verify that a page has completely rendered
	 * 
	 * @param driver
	 * @return boolean
	 */
	
	public static boolean isPageLoaded(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return(Boolean) js.executeScript("return document.readyState").equals("complete");
	}
	
	/*
	 * isAjaxComplete - method to verify that an ajax control has rendered
	 * 
	 * @param driver
	 * @return boolean
	 */
	
	public static boolean isAjaxCompleted(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return(Boolean) js.executeScript("return jQuery.active == 0");
	}

}
