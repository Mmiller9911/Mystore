package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class DriverFactory {
	
	public static WebDriver driver;
	public static HomePage homePage;


public WebDriver SetupDriver() {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\java\\resources\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://mystore.local/my-account/");
	driver.manage().window().maximize();


	homePage = PageFactory.initElements(driver, HomePage.class);

	return driver;
}

public WebDriver getCurrentDriverWithoutInitialisation() {
	return driver;
}
}
