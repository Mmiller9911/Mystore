package steps;

import cucumber.api.java.en.Given;
import utils.DriverFactory;

public class GeneralSteps extends DriverFactory {
	
	
	@Given("^user navigates to the \"([^\\\"]*)\" website$")
	public void user_navigates_to_the_stackoverflow_website(String url) throws Throwable {
		driver.get(url);
	}

}
