package com.freecrm.engine;

import java.net.URL;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

@SuppressWarnings("varargs")
public class SingletonDriver {

	// local variables
	private static SingletonDriver instance = null;
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return webDriver.get();
	}

	@SafeVarargs
	public final void setDriver(String browser, String environment, String platform, Map<String, Object>... optPref)
			throws Exception {

		DesiredCapabilities caps = null;
		FirefoxOptions firefoxopt = null;
		ChromeOptions chromeopt = null;
		EdgeOptions edgeopt = null;
		String localHub = "http://192.168.178.34:4444";
		String remoteHub = "https://YOUR_USERNAME:YOUR_ACCESS_KEY@hub-cloud.browserstack.com/wd/hub";

		switch (browser) {
		case "firefox":
			caps = new DesiredCapabilities();

			if (environment.equalsIgnoreCase("local")) {
				firefoxopt = new FirefoxOptions();
				webDriver.set(new FirefoxDriver(firefoxopt));
				break;

			} else if (environment.equalsIgnoreCase("remote") && platform.equalsIgnoreCase("windows")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.WIN10);
				webDriver.set(new RemoteWebDriver(new URL(localHub), caps));
				break;
			} else if (environment.equalsIgnoreCase("remote") && platform.equalsIgnoreCase("linux")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.LINUX);
				webDriver.set(new RemoteWebDriver(new URL(localHub), caps));
				break;
			}
		case "chrome":
			caps = new DesiredCapabilities();

			if (environment.equalsIgnoreCase("local")) {
				chromeopt = new ChromeOptions();
				webDriver.set(new ChromeDriver(chromeopt));
				break;

			} else if (environment.equalsIgnoreCase("remote") && platform.equalsIgnoreCase("windows")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.WIN10);
				webDriver.set(new RemoteWebDriver(new URL(localHub), caps));
				break;

			} else if (environment.equalsIgnoreCase("remote") && platform.equalsIgnoreCase("linux")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.LINUX);
				webDriver.set(new RemoteWebDriver(new URL(localHub), caps));
				break;
			}
		case "MicrosoftEdge":
			caps = new DesiredCapabilities();

			if (environment.equalsIgnoreCase("local")) {
				edgeopt = new EdgeOptions();
				webDriver.set(new EdgeDriver(edgeopt));
				break;

			} else if (environment.equalsIgnoreCase("remote") && platform.equalsIgnoreCase("windows")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.WIN10);
				webDriver.set(new RemoteWebDriver(new URL(localHub), caps));
				break;

			} else if (environment.equalsIgnoreCase("cloud")) {
				caps.setBrowserName(browser);
				caps.setPlatform(Platform.WIN10);
				webDriver.set(new RemoteWebDriver(new URL(remoteHub), caps));
				break;
			}
		}
	}

	// constructor
	public SingletonDriver() {

	}

	/********************************
	 * 
	 * getInstance method to return active driver instance*
	 * 
	 * @return CreateDriver
	 ********************************/
	public static SingletonDriver getInstance() {
		if (instance == null) {
			instance = new SingletonDriver();
		}
		return instance;
	}
}
