package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAutomation {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://thirdeyecreations.co.in/admin");
		driver.findElement(By.id("email")).sendKeys("thirdeyecreations11@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div/form/button")).click();
		driver.close();
		
		
	}

}
