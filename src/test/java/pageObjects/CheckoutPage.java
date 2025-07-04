package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
	
		this.driver = driver;
		
	}
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoButton = By.cssSelector("button.promoBtn");
	By placeOrderButton = By.xpath("//button[text()='Place Order']");
	
	public void CheckoutItems() {
		
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
		
	}
	
	public Boolean VerifyPromoButton() {
		
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean VerifyPlaceOrderButton() {
		
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
}
