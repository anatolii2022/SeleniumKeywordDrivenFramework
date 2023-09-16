package com.freecrm.engine;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	@Parameters({"browser", "environment", "platform"})
	@BeforeSuite(alwaysRun = true, enabled = true)
	protected void suiteSetUp(@Optional(Default_Values.BROWSER) String browser,
			@Optional(Default_Values.ENVIRONMENT) String environment,
			@Optional(Default_Values.PLATFORM) String platform) throws Exception {
		
		Default_Values.DEFT_BROWSER = System.getProperty("browser", browser);
		Default_Values.DEFT_PLATFROM = System.getProperty("paltform", platform);
		Default_Values.DEFT_ENVIRONMENT = System.getProperty("environment", environment);
		
		SingletonDriver.getInstance().setDriver(Default_Values.DEFT_BROWSER, 
				Default_Values.DEFT_ENVIRONMENT,
				Default_Values.DEFT_PLATFROM);
	}
}
