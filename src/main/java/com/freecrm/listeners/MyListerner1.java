package com.freecrm.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListerner1 implements WebDriverListener {
	
	private static final Logger log = Logger.getLogger(MyListerner1.class);
	
	//Constructor
	public MyListerner1() {
		super();
		PropertyConfigurator.configure("src\\main\\resources\\log4j2.properties");
	}
	
	public void beforeGet(WebDriver driver, String url) {
		log.info("Navigateing to " + url);
	}
	
	public void afterGet(WebDriver driver, String url) {
		log.info("Navigated to " + url);
	}
	
	public void beforeFindElement(WebDriver driver, By locator) {
		log.info("Finding element " + locator);
	}
	
	public void afterFindElement(WebDriver driver, By locator) {
		log.info("Found element " + locator);
	}
	
	public void beforeClick(WebElement element) {
		log.info("Clicking on " + element);
	}
	
	public void afterClick(WebElement element) {
		log.info("Clicked on " + element);
	}
	
	public void beforeQuit(WebDriver driver) {
		log.info("Quitting" + driver);
	}
	
	public void afterQuit(WebDriver driver) {
		log.info("Quitted" + driver);
	}

}
