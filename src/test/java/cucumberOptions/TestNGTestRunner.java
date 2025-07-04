package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue = "stepDefinations",monochrome = true,
plugin = {"pretty", "html:target/Cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
//	Below method is to execute the tests in parallel
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		
		return super.scenarios();
		
	}
	
//	mvn commands url
//	https://cucumber.io/docs/cucumber/api/#options
//	-Dcucumber.filter.tags="@"$tags""
}
