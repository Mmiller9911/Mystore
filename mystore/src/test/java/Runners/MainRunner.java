package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		features= {"src/test/java/features/"}, //points to the feature file location
		glue = {"steps"}, //point to the step definitions
		monochrome = true, //setting this to false makes the output less human readable
		tags = {"@check"}, //which tags to run and not
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
		)


public class MainRunner extends AbstractTestNGCucumberTests{


}
