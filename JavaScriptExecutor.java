package ui;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		JavascriptExecutor js_exec = (JavascriptExecutor) driver;
		
		/*Print title of the page*/
		String script = "return document.title;";
		String title = (String) js_exec.executeScript(script);
		System.out.println(title);
		
		/*Click a button*/
		driver.switchTo().frame("iframeResult");
		js_exec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		/*Highlight a button*/
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		js_exec.executeScript("arguments[0].style.border='5px solid red'", button);
		
		/*Scroll to a WebElement*/
		driver.navigate().to("https://www.w3schools.com/");
		WebElement locateelement = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[1]/a[4]"));
		js_exec.executeAsyncScript("arguments[0].scrollIntoView(true);", locateelement);
		
		
	}

}
