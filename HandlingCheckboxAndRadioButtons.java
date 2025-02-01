package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckboxAndRadioButtons {

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
		
		//handling checkboxes
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		
		
		//handling radio buttons
		driver.get("https://www.singaporeair.com/en_UK/ca/home#/book/bookflight");
		driver.manage().window().maximize();
		
		//To manage element click intercepted error
		WebElement scroll = driver.findElement(By.xpath("//button[@id='submitbtn']"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll);
		action.perform();
		Thread.sleep(3000);
		
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		WebElement radio1 = driver.findElement(By.id("bookFlights"));
		radio2.click();
		System.out.println(radio2.isSelected());
		System.out.println(radio1.isSelected());

	}

}
