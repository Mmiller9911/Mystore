package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Constant;

public class JunitTests {
	
	WebDriver driver;

	
	@BeforeMethod
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://mystore.local/my-account/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		driver.manage().deleteAllCookies();
		driver.close();
	}

   
	String textfield_username =  "username";
	String textfield_password =  "//input[@type='password']";
	String login_button =  "//button[@name='login']";
	String register_button =  "//button[@name='register']";
	String errorfield = "//div[@id='content']//li[1]";
	String logout = "//a[contains(text(),'Log out')]";

	
	public void checkIncorrectLogin(String username, String password, String expectederror) {
		  driver.findElement(By.id(textfield_username)).sendKeys(username);
		  driver.findElement(By.xpath(textfield_password)).sendKeys(password);
		  driver.findElement(By.xpath(login_button)).click();
		  String actual = driver.findElement(By.xpath(errorfield)).getText();
		  Assert.assertEquals(expectederror, actual);
	}
	
	@Test(description="User can log in with valid username and password")
	public void validLogin() throws Exception{
	  driver.findElement(By.id(textfield_username)).sendKeys("matt.miller@mqmsolutions.com");
	  driver.findElement(By.xpath(textfield_password)).sendKeys("hunky123!");
	  driver.findElement(By.xpath(login_button)).click();
	  Boolean isPresent = driver.findElements(By.xpath(logout)).size() > 0;
	  Assert.assertTrue(isPresent);
	  Thread.sleep(5000);
	}
	
	@Test(description="Login with a valid username and invalid password")
	public void invalidLogin1() throws Exception{
	  checkIncorrectLogin("matt.miller@mqmsolutions.com", "invalid", "Error: The password you entered for the email address matt.miller@mqmsolutions.com is incorrect. Lost your password?");
	  Thread.sleep(5000);
	}
	
	@Test(description="Login with an invalid username and invalid password")
	public void invalidLogin2() throws Exception{
	  checkIncorrectLogin("invalid", "invalid", "Unknown username. Check again or try your email address.");
	  Thread.sleep(5000);
	}
	
	@Test(description="Login with valid username but no password")
	public void invalidLogin3() throws Exception{
	  checkIncorrectLogin("matt.miller@mqmsolutions.com", "", "Error: The password field is empty.");
	  Thread.sleep(5000);
	}
	
	@Test(description="Login with no username and valid password")
	public void invalidLogin4() throws Exception{
	  checkIncorrectLogin("", "hunky123!", "Error: Username is required.");
	  Thread.sleep(5000);
	}
	
	@Test(description="Login no username or password")
	public void invalidLogin5() throws Exception{
	  checkIncorrectLogin("", "", "Error: Username is required.");
	  Thread.sleep(5000);
	}
	
	@Test(description="Login invalid email address")
	public void invalidLogin6() throws Exception{
	  driver.findElement(By.xpath(register_button)).click();
	  String actual = driver.findElement(By.xpath(errorfield)).getText();
	  Assert.assertEquals("Error: Please provide a valid email address.", actual);
	  Thread.sleep(5000);
	}

}
