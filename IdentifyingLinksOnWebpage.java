package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IdentifyingLinksOnWebpage {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.sugarcrm.com/request-demo/");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: "+alllinks.size());
		
		for(int i=0;i<alllinks.size();i++) {
			System.out.println("Link is: "+alllinks.get(i).getAttribute("href"));
		}
		

	}

}
