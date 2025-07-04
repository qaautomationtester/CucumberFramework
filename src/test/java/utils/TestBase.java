package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("QAUrl");
		
		if(driver == null)
		{
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
				
				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
			
		}
		
		return driver;
		
	}
	
}
