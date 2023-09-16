package com.freecrm.smoketests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SmokeTest2Linux {
	
	RemoteWebDriver driver;
	
	@Test(enabled =  false)
	public void test1() throws InterruptedException {
		
		ChromeOptions chromeoptions = new ChromeOptions();
	
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.178.34:4444"), chromeoptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");
		driver.findElement(By.id("W0wltc")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium Grid");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(enabled = false)
	public void test2() throws InterruptedException {
		
		FirefoxOptions firefoxoptions = new FirefoxOptions();
	
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.178.34:4444"), firefoxoptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");
		driver.findElement(By.id("W0wltc")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium Grid");
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	@Test(enabled = true, groups = "windows")
	public void test3() throws InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WIN10);
 
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.178.34:4444"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");
		driver.findElement(By.id("W0wltc")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium Grid");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(enabled = true, groups = "linux")
	public void test4() throws InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.LINUX);
 
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.178.34:4444"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com");
		driver.findElement(By.id("W0wltc")).click();
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium Grid");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.quit();
	}

}
