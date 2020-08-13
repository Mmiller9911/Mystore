package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() throws Exception {
		driver = SetupDriver();
		
	}
	
	@After
	public void teardownAndScreenshotOnFailure(Scenario scenario) throws Exception {
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = null;
		}

		
	}
