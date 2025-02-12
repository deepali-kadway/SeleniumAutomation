package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAndKeyboardFunctions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Mouse Hover Function
		 driver.get("https://www.ebay.com.au/"); WebElement element =
		 driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/a"));
		 Actions action = new Actions(driver);
		 action.moveToElement(element).perform();
	
		//Drag & Drop Function 
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame1);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action1 = new Actions(driver);
		action1.dragAndDrop(drag, drop).perform();
		
		
		//Resize or Slider Widget function
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		WebElement frame2 = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame2);
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		Actions action2 = new Actions(driver);
		action2.dragAndDropBy(slider, 200, 10).perform();
		
		//Right-Click function
		Thread.sleep(4000);
		action2.contextClick().perform();
        
		//Keyboard Events using Selenium
		driver.get("https://extendsclass.com/text-compare.html#google_vignette");
		WebElement source = driver.findElement(By.xpath("//*[@id=\"result\"]/div[4]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/pre[3]"));
		Actions action3 = new Actions(driver);
		Thread.sleep(2000);
		action3.keyDown(source, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"result\"]/div[5]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/pre[4]"));
		Thread.sleep(2000);
		action3.keyDown(destination, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
	}

}
