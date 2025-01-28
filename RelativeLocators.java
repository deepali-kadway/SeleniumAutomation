package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.get("https://thirdeyecreations.co.in/shops/create");
		WebElement locateemail = driver.findElement(By.name("email")); //find email field, above which name is there
		WebElement locatename = driver.findElement(RelativeLocator.with(By.tagName("input")).above(locateemail));
		locatename.sendKeys("1234");
		
	}

}
