package com.freecrm.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.freecrm.engine.SingletonDriver;
import com.freecrm.listeners.MyListerner1;

public class ActionKeywords {
	
	MyListerner1 listener = new MyListerner1();
	
	WebDriver driver = null;
	WebDriver decorated = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void openBrowser( ) {
		try {
			//SingletonDriver.getInstance().setDriver(browser, environment, platform);
			driver = SingletonDriver.getInstance().getDriver();
			decorated = new EventFiringDecorator(listener).decorate(driver);
			decorated.manage().window().maximize();
			SessionId session = ((RemoteWebDriver) SingletonDriver.getInstance().getDriver()).getSessionId();
			System.out.println("Session is: " + session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void navigate(String URL) {
		decorated.get(URL);
	}

	public void clickElement(String xpath) {
		decorated.findElement(By.xpath(xpath)).click();
	}
	
	public void enterText(String xpath, String text) {
		decorated.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public void screenshotElement(String xpath) {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		File srcFile = decorated.findElement(By.xpath(xpath)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./screenshots/" + sdf.format(date) + "-screenshot.png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		decorated.quit();
	}
}
