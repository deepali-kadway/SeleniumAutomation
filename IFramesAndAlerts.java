package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFramesAndAlerts {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		/*
		 * identifying a frame by index. 
		 * driver.switchTo().frame(1);
		 * driver.findElement(By.xpath("/html/body/button")).click();
		 */
		
		/*
		 * identifying a frame by id or name 
		 * driver.switchTo().frame("iframeResult");
		 * driver.findElement(By.xpath("/html/body/button")).click();
		 */

		//identifying a frame by frame element
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("/html/body/button")).click();
		
		String getalertText = driver.switchTo().alert().getText();
		System.out.println(getalertText);
		
		driver.switchTo().alert().accept();
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
	}

}
