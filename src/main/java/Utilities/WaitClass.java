package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freecrm.engine.SingletonDriver;

public class WaitClass {
	
	WebDriverWait explicitWait = null;
	
	//constructor
	public WaitClass() {
		explicitWait = new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(30));
	}
	
	//Switch to frame
	public void switchToFrame(String xpath) {
		explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath))));
	}
	
	//Wait for element to be clickable
	public void waitForClickable(String xpath) {
		explicitWait.until(ExpectedConditions.elementToBeClickable(SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath))));
	}
	
	//Wait for element implicitly
	public void waitImplicitly() {
		SingletonDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

}
