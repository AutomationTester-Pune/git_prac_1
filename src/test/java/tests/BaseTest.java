package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	ThreadLocal<WebDriver> driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ThreadLocal<WebDriver>();
		driver.set(new ChromeDriver());
		driver.get().get("https://testautomationpractice.blogspot.com/");
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.get().quit();
		driver.remove();
	}

}
