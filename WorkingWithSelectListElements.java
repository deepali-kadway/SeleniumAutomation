package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithSelectListElements {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.sugarcrm.com/request-demo/");
		driver.manage().window().maximize();
		
		//First locate a <select> element, then use it to initialize the select object.
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='input_1_8']"));
		Select select = new Select(dropdown);
		
		//Use methods to select any value from dropdown
		select.selectByIndex(4);
		select.selectByValue("level7");
		select.selectByVisibleText("1-10 employees");
		
		
		//Code to handle multiselect dropdown
		driver.get("https://www.selenium.dev/selenium/web/formPage.html");
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='multi']"));
		Select multiselect = new Select(dropdown1);
		multiselect.deselectAll();
		multiselect.selectByValue("eggs");
		Thread.sleep(2000);
		multiselect.selectByIndex(3);
		Thread.sleep(2000);
		List<WebElement> allitems = multiselect.getAllSelectedOptions();
		System.out.println(allitems.size());
		multiselect.deselectByIndex(3);
		multiselect.selectByIndex(2);
		multiselect.deselectByIndex(2);
		
		
	}

}
