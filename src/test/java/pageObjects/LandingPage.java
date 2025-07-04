package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
	
		this.driver = driver;
		
	}

	private By serach = By.xpath("//input[@type='search']");
	private By productName = By.xpath("//h4");
	private By topDealsLink = By.linkText("Top Deals");
	By increment = By.cssSelector("a.increment");
	By adddToCartButton = By.xpath("//button[text()='ADD TO CART']");
	
	public void searchItem(String name) {
		
		driver.findElement(serach).sendKeys(name);
		
	}
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
		
	}
	
	public void selectTopDeals() {
		
		driver.findElement(topDealsLink).click();
		
	}
	
public void incrementTheQuantity(int quantity) {
		
		int i = quantity;
		for(int j=1;j<i;j++) {
			
		driver.findElement(increment).click();
			
		}
		
	}
	
	public void addToCart() {
		
		driver.findElement(adddToCartButton).click();
		
	}
	
}
