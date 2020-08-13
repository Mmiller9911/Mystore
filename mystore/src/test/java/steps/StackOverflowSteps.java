package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class StackOverflowSteps extends DriverFactory {
	@Given("^the user presses the login button on the home page$")
	public void the_user_presses_the_login_button_on_the_home_page() throws Throwable {
		//driver.findElement(By.linkText("Log in"));
		driver.findElement(By.xpath("//a[contains(text(), 'Log in')]")).click();
		
	}
	
	@Given("^the user enters a valid username$")
	public void the_user_enters_a_valid_username() throws Throwable {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mmiller9911@gmail.com");
	}

	@Given("^the user enters a valid password$")
	public void the_user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("nK&Q58_-5$AkX4t");
	}
	

	@When("^the user presses the login button$")
	public void the_user_presses_the_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='submit-button']")).click();
	}

	@Then("^the user should be taken to the successful log in page$")
	public void the_user_should_be_taken_to_the_successful_log_in_page() throws Throwable {
		WebElement askquestion = driver.findElement(By.xpath("//a[@class='ws-nowrap s-btn s-btn__primary']"));
		Assert.assertEquals(true, askquestion.isDisplayed()); 
	}
}
