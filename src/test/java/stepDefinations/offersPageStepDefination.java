package stepDefinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectMnanger;
import utils.TestContextSetup;

public class offersPageStepDefination {
	
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	PageObjectMnanger pageObjectManager;
	
	public offersPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String productShortname) throws InterruptedException {
	   
		switchToOffersPage();
		
		OffersPage offerspage = testContextSetup.pageObjectMnanger.getOffersPage();
		offerspage.searchItem(productShortname);
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productShortname);
//		//tbody/tr/td[1]
		Thread.sleep(2000);
//		offersPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offersPageProductName = offerspage.getProductName();
		
	}
	
	public void switchToOffersPage() {
		
//		if switched to offers page => skip the below part
		
//		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		
//		pageObjectManager = new PageObjectMnanger(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectMnanger.getLandingPage();
		landingPage.selectTopDeals();
//		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		
		testContextSetup.genericUtils.SwitchWindowToChild();
		
//		Set<String> s1 = testContextSetup.driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//		String parentWindow = i1.next();
//		String childWindow = i1.next();
//		
//		testContextSetup.driver.switchTo().window(childWindow);
		
	}
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() throws IOException {
	    
		Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName);
//		testContextSetup.testBase.webDriverManager().quit();
		
	}
	
}
