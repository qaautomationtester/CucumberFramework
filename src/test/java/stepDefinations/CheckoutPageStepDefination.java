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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectMnanger.getCheckoutPage();	
	}
	
	@Then("^User proceeds to checkout and validate the (.+) item in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_wal_item_in_checkout_page(String productShortName) throws InterruptedException {
	   
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
		
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	    
		Assert.assertTrue(checkoutPage.VerifyPromoButton());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrderButton());
		
	}

}
