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
import utils.TestBase;
import utils.TestContextSetup;

public class landingPageStepDefination {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public landingPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectMnanger.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
	    
//		testContextSetup.testBase.webDriverManager();
		
	}
	
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productShortname) throws InterruptedException {
		
		landingPage.searchItem(productShortname);
		
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productShortname);
		Thread.sleep(2000);
//		testContextSetup.landingPageProductName =  testContextSetup.driver.findElement(By.xpath("//h4")).getText().split("-")[0].trim();
		testContextSetup.landingPageProductName =  landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName +" is extracted form Home page");
		
	}
	
	@When("^Added (.+) items of the selected product to cart$")
	public void added_items_of_the_selected_product_to_cart(String quantity) {
	    
		landingPage.incrementTheQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}	

}
