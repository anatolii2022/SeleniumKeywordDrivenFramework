package com.freecrm.actions;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.freecrm.engine.SingletonDriver;

public class ActionsExecutor {
	
	//Constructor
	public ActionsExecutor() {
		
	}
	
	// Rigt click on the element
	public static void  rightClickElement(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.contextClick(elem).perform();
	}
	
	//Double click on the element
	public static void  doubleClickElement(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.doubleClick(elem).perform();
	}
	
	//Drag and Drop on an element
	public static void  dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.dragAndDrop(source, target).perform();
	}

	//Hover on an element
	public static void  mouseOver(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.moveToElement(elem).perform();
	}
	
	//Keydown on an element
	public static void  keyDown(Keys key) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.keyDown(key).perform();
	}
	
	//KeyUp on an element
	public static void  keyUp(Keys key) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.keyUp(key).perform();
	}
	
	//Click and hold and move an element
	public static void  clickAndHoldAndMove(WebElement target, int xOff, int yOff) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.clickAndHold(target).moveByOffset(xOff, yOff).perform();
	}

	

}
