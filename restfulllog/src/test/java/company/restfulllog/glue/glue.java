package company.restfulllog.glue;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				features = "src/test/resources/features",
				glue = "company.restfulllog.step",
				plugin = {
						"pretty",
						"json:reports/cucumber.json",
						"html:reports/cucumber-report.html"
						 }
				)

public class glue extends AbstractTestNGCucumberTests
{

}
