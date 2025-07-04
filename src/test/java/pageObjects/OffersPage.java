package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
public WebDriver driver;
	
	public OffersPage(WebDriver driver) {
	
		this.driver = driver;
		
	}

	private By serach = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name) {
		
		driver.findElement(serach).sendKeys(name);
		
	}
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
		
	}

}
