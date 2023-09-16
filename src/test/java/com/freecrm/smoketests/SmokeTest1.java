package com.freecrm.smoketests;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.freecrm.actions.ActionKeywords;
import com.freecrm.actions.Assertions;
import com.freecrm.engine.BaseClass;
import com.freecrm.engine.DBExtract;
import com.freecrm.engine.SingletonDriver;

import Utilities.WaitClass;

public class SmokeTest1 extends BaseClass {

	ActionKeywords actKeywords = new ActionKeywords();
	Assertions assertions = new Assertions();
	WaitClass wdWait = null;
	
	ExtentReports report = null;
	ExtentSparkReporter reporter = null;
	ExtentTest test = null;

	@BeforeTest(groups = { "GroupA", "GroupB", "GroupC","GroupD","GroupE" })
	public void setUp() {
		
		actKeywords.openBrowser();
		wdWait = new WaitClass();
		wdWait.waitImplicitly();
		
		String reportPath = System.getProperty("user.dir") + "\\reports\\report.html";
		
		reporter = new ExtentSparkReporter(reportPath);
		report = new ExtentReports();
		report.attachReporter(reporter);
		test = report.createTest("SmokeTest");
	}

	@Test(groups = {"GroupA","GroupE"})
	public void test1(ITestContext itestContext) {
		System.out.println("Before starting test1");
		test.log(Status.PASS, "Test 1 started");

		try {
			String[] group = itestContext.getIncludedGroups();
			CachedRowSet crs = DBExtract.extractRecords(group[0]);
			ResultSetMetaData rsmd = crs.getMetaData();
			crs.next();

			while (!crs.isAfterLast()) {
				String testcaseId = crs.getString("TestCaseID");
				String teststepId = crs.getString("TestStepID");

				String actionKey = crs.getString("ActionKey");
				System.out.println("ActionKey: " + actionKey);
				String expected = crs.getString("Expected");
				System.out.println("Expected value: " + expected);
				String xpath = crs.getString("XPath");
				System.out.println("XPath: " + xpath);
				String dataKey = crs.getString("DataKey");
				System.out.println("DataKey: " + dataKey);

				switch (actionKey) {
				case "navigate":
					actKeywords.navigate(dataKey);
					test.pass("Navigated to: " + dataKey);
					break;
				case "click":
					actKeywords.clickElement(xpath);
					test.pass("Clicked on: " + xpath);
					break;
				case "entertext":
					actKeywords.enterText(xpath, dataKey);
					test.pass("Entered text: " + dataKey);
					break;
				case "verifyText":
					assertions.assertEqualsSA(SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath)).getText(), expected);
					test.pass("Text verified");
					break;
				case "screenshot":
					actKeywords.screenshotElement(xpath);
					test.pass("Screenshot made");
					break;
				case "visible":
					WebElement element = SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath));
					assertions.checkVisible(element);
					test.pass("Checked visability: " + element);
				}
				crs.next();
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			test.log(Status.FAIL, "Test 1 failed");
		}

		System.out.println("After completing test1");
		test.log(Status.PASS, "Test 1 finished");
	}
	
	@AfterTest(groups = { "GroupA", "GroupB", "GroupC","GroupD","GroupE" })
	public void tearDown() {
		actKeywords.closeBrowser();
		report.flush();
		assertions.assertAll();
		
		
	}
}
