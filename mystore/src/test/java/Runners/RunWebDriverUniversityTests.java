package Runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import java.io.File;
import java.io.IOException;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import pages.BasePage;

@RunWith(Cucumber.class)

@CucumberOptions(
		features= {"src/test/java/features/"}, //points to the feature file location
		glue = {"steps"}, //point to the step definitions
		monochrome = true, //setting this to false makes the output less human readable
		tags = {"@all"}, //which tags to run and not
		plugin = {"pretty", "html:output/cucumber", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		//plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		)


public class RunWebDriverUniversityTests extends AbstractTestNGCucumberTests{

	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		BasePage.copyLatestExtentReport();
	}
}