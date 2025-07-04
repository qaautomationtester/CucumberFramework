package pageObjects;

import org.openqa.selenium.WebDriver;

import stepDefinations.offersPageStepDefination;

public class PageObjectMnanger {

	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	
	public PageObjectMnanger(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public LandingPage getLandingPage() {
		
		landingPage = new LandingPage(driver);
		return landingPage;
		
	}
	
	public OffersPage getOffersPage() {
		
		offersPage = new OffersPage(driver);
		return offersPage;
		
	}
	
	public CheckoutPage getCheckoutPage() {
		
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
		
	}
	
}
