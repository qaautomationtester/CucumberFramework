package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class SalesforceStepDefination {

	public WebDriver driver;
	public Actions action;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
	}
	
	@When("the user logs in with email {string} and password {string}")
	public void the_user_logs_in_with_email_and_password(String username, String password) {
	    
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@Then("the user should be successfully logged in")
	public void the_user_should_be_successfully_logged_in() throws InterruptedException {
	    Thread.sleep(10000);
		String title =  driver.findElement(By.xpath("//span[@title='Quarterly Performance']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "Quarterly Performance");
		
	}
	
	@When("the user logs out")
	public void the_user_logs_out() throws InterruptedException {
	    
		WebElement elementToHover = driver.findElement(By.cssSelector("span.photoContainer"));
		action = new Actions(driver);
		action.moveToElement(elementToHover).perform();
		driver.findElement(By.cssSelector("span.photoContainer")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log Out")).click();
		
	}
	
	@Then("the user should be successfully logged out")
	public void the_user_should_be_successfully_logged_out() throws InterruptedException {
		
		Thread.sleep(5000);
		String title = driver.findElement(By.xpath("//span[text()='Salesforce']")).getText();
		Assert.assertEquals(title, "Salesforce");
		driver.close();
		
	}
	
}
