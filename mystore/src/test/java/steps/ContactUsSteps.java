package steps;

import java.io.IOException;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactUsSteps extends DriverFactory {

	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws IOException {
		contactUsPage.getContactUsPage();
	}

	@When("^I enter a valid firstname$")
	public void i_enter_a_valid_firstname() throws Exception {
		contactUsPage.enterFirstName("Tom");
	}

	@When("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable dataTable) throws Exception {
		contactUsPage.enterLastName(dataTable, 0, 1);
	}

	@And("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Exception {
		contactUsPage.enterEmailAddress("webdriveruniversity@outlook.com");
	}

	@And("^I enter comments$")
	public void i_enter_comments1(DataTable dataTable) throws Exception {
		contactUsPage.enterComments(dataTable, 0, 1);
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button1() throws Exception {
		contactUsPage.clickOnSubmiButton();
	}

	@Then("^the information should successfully be submitted via the contact us form$")
	public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Exception {
		contactUsPage.confirmContactUsFormSubmissionWasSuccessful();
	}

	@Given("^I enter \"([^\"]*)\" as my username$")
	public void i_enter_my_username(String username) throws Throwable {
		driver.findElement(By.id("text")).sendKeys(username);
	}

	@Given("^I enter \"([^\"]*)\" as my password$")
	public void i_enter_a_password(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@Given("^I enter \"([^\"]*)\" as my login page username$")
	public void i_enter_username(String arg1) throws Throwable {
		driver.findElement(By.id("text")).sendKeys(arg1);
		Thread.sleep(2000);
	}

	@Given("^I enter \"([^\"]*)\" as my login page password$")
	public void i_enter_password(String arg1) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(arg1);
		Thread.sleep(2000);
	}

	@Given("^I press the confirm button$")
	public void i_press_confirm() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("^I should get a \"([^\\\"]*)\" alert$")
	public void i_should_get_a_alert(String state) throws Throwable {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""),
				state.toLowerCase().replaceAll("\\s", ""));
		alert.accept();
	}

	@Given("^I access webdriveruniversity$")
	public void i_access_webdriveruniversity() throws Throwable {
		driver.get("http://www.webdriveruniversity.com/");
	}

	@Given("^I access webdriveruniversity login portal$")
	public void i_access_webdriveruniversity_loginportal() throws Throwable {
		driver.get("http://www.webdriveruniversity.com/Login-Portal/");
		// System.out.println(driver.getPageSource());
	}

	@Given("^I click on the contact us button$")
	public void i_click_on_the_contact_us_button() throws Throwable {
		driver.findElement(By.xpath("//h1[contains(text(),'CONTACT US')]")).click();

	}

	@Given("^I enter firstname$")
	public void i_enter_firstname() throws Throwable {

		String parentWindow = driver.getWindowHandle(); // get the current window and save to variable
		Set<String> handles = driver.getWindowHandles(); // get all open windows
		for (String windowHandle : handles) // for each window in the set
		{
			if (!windowHandle.equals(parentWindow)) // if the window isn't the parent one
			{
				driver.switchTo().window(windowHandle); // switch to it
				driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("matthew");
//		         driver.close(); //closing child window
//		         driver.switchTo().window(parentWindow); //control to parent window
			}
		}
	}

	@Given("^I enter surname$")
	public void i_enter_surname() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("miller");
	}

	@Given("^I enter email address$")
	public void i_enter_email_address() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("mmiller9911@gmail.com");
	}

	@Given("^I enter an invalid email address$")
	public void i_enter_an_invalid_email_address() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("invalid");
	}

//	@Given("^I enter comments$")
//	public void i_enter_comments(DataTable arg1) throws Throwable {
//		List<List<String>> data = arg1.raw();
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(0) + "\n");
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(0).get(1) + "\n");
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(1).get(0) + "\n");
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(1).get(1) + "\n");
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(2).get(0) + "\n");
//		driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(data.get(2).get(1) + "\n");
//	}

	@When("^I click on the reset button$")
	public void i_click_on_the_reset_button() throws Throwable {
		driver.findElement(By.xpath("//div[@id='form_buttons']//input[1]")).click();
	}

	@Then("^the information should be removed$")
	public void the_information_should_be_removed() throws Throwable {
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement surname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		WebElement comments = driver.findElement(By.xpath("//textarea[@placeholder='Comments']"));
		String textInsideInputFirstname = firstname.getAttribute("value");
		String textInsideInputSurname = surname.getAttribute("value");
		String textInsideInputEmail = email.getAttribute("value");
		String textInsideInputComments = comments.getAttribute("value");
		Assert.assertTrue(textInsideInputFirstname.isEmpty());
		Assert.assertTrue(textInsideInputSurname.isEmpty());
		Assert.assertTrue(textInsideInputEmail.isEmpty());
		Assert.assertTrue(textInsideInputComments.isEmpty());
	}

	/*
	 * @When("^I click on the submit button$") public void
	 * i_click_on_the_submit_button() throws Throwable {
	 * driver.findElement(By.xpath("//div[@id='form_buttons']//input[2]")).click();
	 * 
	 * }
	 */

	@Then("^the information should be successfully be submitted via the contact us form$")
	public void the_information_should_be_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
		WebElement successmessage = driver
				.findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]"));
		Assert.assertEquals(true, successmessage.isDisplayed());

	}

	@Then("^an error message should be seen$")
	public void an_error_message_should_be_seen() throws Throwable {
		// System.out.println(driver.getPageSource());
		Assert.assertTrue(driver.getPageSource().contains("Error: Invalid email address"));
	}

	@Then("^the information should not be successfully be submitted via the contact us form$")
	public void the_information_should_not_be_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
		WebElement failuremessage = driver
				.findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]"));
		Assert.assertEquals(true, failuremessage.isDisplayed());

	}
}
