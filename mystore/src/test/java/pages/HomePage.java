package pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.DriverFactory;


public class HomePage extends DriverFactory{
	
    
     @FindBy(how = How.ID, using="username") //method one for getting elements
    WebElement textfield_username;
    
	private @FindBy(xpath = "//input[@type='password']") WebElement textfield_password;
	private @FindBy(xpath = "//button[@name='login']") WebElement login_button;
	public @FindBy(xpath = "//button[@name='register']") WebElement register_button;

    
	public HomePage() throws IOException {
	}

    public void enterUsername(String username) {
    	textfield_username.sendKeys(username);
    	//return new ContactUs_Page();
    }
    
    public void enterPassword(String password) {
    	textfield_password.sendKeys(password);
    }

    public void pressLoginButton() {
    	login_button.click();
    }
    
}