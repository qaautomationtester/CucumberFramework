package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectMnanger;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectMnanger pageObjectMnanger;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		pageObjectMnanger = new PageObjectMnanger(testBase.webDriverManager());
		genericUtils = new GenericUtils(testBase.webDriverManager());
		
	}
	
	
}
