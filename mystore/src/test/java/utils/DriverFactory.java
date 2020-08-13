package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;
import pages.ContactUs_Page;
import pages.Products_Page;
import pages.HomePage;
import utils.Constant;

public class DriverFactory {
	public static WebDriver driver;
	public static HomePage homePage;
	public static BasePage basePage;
	public static ContactUs_Page contactUsPage;
	public static Products_Page productsPage;
	

	public WebDriver getCurrentDriverWithoutInitialisation() {
		return driver;
	}

	public WebDriver SetupDriver() {
		try {
			// Read Config from the config file so it can be used easily by batch/jenkins
			Properties p = new Properties();                          // go to here C:\CucumberProject\CucumberProject\src\main\java\properties
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\properties\\config.properties");
			p.load(fi);
			String browserName = p.getProperty("browser");

			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			homePage = PageFactory.initElements(driver, HomePage.class);
			contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
			productsPage = PageFactory.initElements(driver, Products_Page.class);
			basePage = PageFactory.initElements(driver, BasePage.class);
			driver.get("http://mystore.local/my-account/");
			driver.manage().window().maximize();
		}
		return driver;
	}
}



