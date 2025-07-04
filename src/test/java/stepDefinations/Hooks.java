package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.FileUtil;

import io.cucumber.java.*;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		
	}
	
//	@Before
//	public void BeforeScenario() {
//		
//		
//	}
	
	@After
	public void AfterScenario() throws IOException {
		
		testContextSetup.testBase.webDriverManager().quit();
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		
		WebDriver driver = testContextSetup.testBase.webDriverManager();
		if(scenario.isFailed()) {
			
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
			
		}
		
	}
	
}
