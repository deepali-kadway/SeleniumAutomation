package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDowns {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		
		 driver.get("https://www.cleartrip.com/hotels");
		 driver.manage().window().maximize(); Thread.sleep(3000);
		 
		 //identify the element on web page where you have to enter the text.
		 WebElement find = driver.findElement(By.xpath("//*[@id=\"__next\"]//input"));
		 find.sendKeys("London"); 
		 Thread.sleep(5000); 
		 find.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(2000); 
		 find.sendKeys(Keys.ENTER);
		
	}

}
