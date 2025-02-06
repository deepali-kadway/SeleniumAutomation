package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathfunctions {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

	// xpath function "starts-with"
		driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");
		driver.findElement(By.xpath("//input[starts-with(@id,'UserLastName')]")).sendKeys("test");
		
		//xpath function "contains"
		driver.findElement(By.xpath("//input[contains(@id,'FirstName')]")).sendKeys("test");
		
		//xpath function "text()"
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[text()='Gmail']")).click(); 
		
		//xpath function AND - OR
		driver.findElement(By.xpath("//input[@type='text' and @name='UserFirstName']")).sendKeys("Test");
		
		//xpath axes methods (parent, child, self)
		driver.findElement(By.xpath("//select[@name='CompanyEmployees']//child::option[2]")).click();
		//above I have located parent tag of child i.e select and then identified it's child tag options and
		//passed value identifier which I wanted to select.		
		
		
	}

}
