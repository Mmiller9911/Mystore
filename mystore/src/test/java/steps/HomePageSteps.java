package steps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.DriverFactory;


public class HomePageSteps extends DriverFactory {
	
	@Given("^I enter \"([^\"]*)\" as my username$")
	public void i_enter_login_username(String username) throws IOException, InterruptedException {
		homePage.enterUsername(username);
		Thread.sleep(1000);
	}
	@Given("^I enter \"([^\"]*)\" as my password$")
	public void i_enter_login_password(String password) throws IOException, InterruptedException {
		homePage.enterPassword(password);
		Thread.sleep(1000);
	}
	@Given("^I click login button after entering login details$")
	public void click_login_button() throws IOException, InterruptedException {
		homePage.pressLoginButton();
		Thread.sleep(1000);
	}
	@Given("^I click register button$")
	public void click_register_button() throws IOException, InterruptedException {
		getCurrentDriverWithoutInitialisation().findElement(By.xpath("//button[@name='register']")).click();
		Thread.sleep(1000);
	}
	
	@Then("^I should see an error message$")
	public void errorMessageDisplayed() throws InterruptedException {
		String errorMsg = "Error: Please provide a valid email address.";		
		String text = getCurrentDriverWithoutInitialisation().findElement(By.xpath("//div[@id='content']//li[1]")).getText();
		Assert.assertEquals(errorMsg, text);
		Thread.sleep(1000);
	}
	@Then("^I should see a bad password error message$")
	public void badPasswordMessageDisplayed() throws InterruptedException {
		String errorMsg = "Error: The password you entered for the email address matt.miller@mqmsolutions.com is incorrect. Lost your password?";		
		String text = getCurrentDriverWithoutInitialisation().findElement(By.xpath("//div[@id='content']//li[1]")).getText();
		System.out.print(errorMsg);
		System.out.print(text);
		Assert.assertEquals(errorMsg, text);
		
		Thread.sleep(1000);
	}
	
	@Then("^I should see a bad username error message$")
	public void badUsernameMessageDisplayed() throws InterruptedException {
		String errorMsg = "Unknown username. Check again or try your email address.";		
		String text = getCurrentDriverWithoutInitialisation().findElement(By.xpath("//div[@id='content']//li[1]")).getText();
		System.out.print(errorMsg);
		System.out.print(text);
		Assert.assertEquals(errorMsg, text);
		
		Thread.sleep(1000);
	}
	
	@Then("^I should see a no password error message$")
	public void nopasswordMessageDisplayed() throws InterruptedException {
		String errorMsg = "Error: The password field is empty.";		
		String text = getCurrentDriverWithoutInitialisation().findElement(By.xpath("//div[@id='content']//li[1]")).getText();
		System.out.print(errorMsg);
		System.out.print(text);
		Assert.assertEquals(errorMsg, text);
		
		Thread.sleep(1000);
	}
	
	@Then("^I should see a no username error message$")
	public void nousernameMessageDisplayed() throws InterruptedException {
		String errorMsg = "Error: Username is required.";		
		String text = getCurrentDriverWithoutInitialisation().findElement(By.xpath("//div[@id='content']//li[1]")).getText();
		System.out.print(errorMsg);
		System.out.print(text);
		Assert.assertEquals(errorMsg, text);
		
		Thread.sleep(1000);
	}
	
}