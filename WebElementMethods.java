package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static String browser = "chrome"; // external configuration
	public static WebDriver driver;  // assign global object driver against WebDriver
	public static void main(String[] args) {
		

			if (browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (browser.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			driver.get("https://www.sugarcrm.com/request-demo/");
			driver.findElement(By.name("input_3.3")).sendKeys("Deepali");
			driver.findElement(By.name("input_3.3")).clear();
			System.out.println(driver.findElement(By.name("input_3.3")).getAttribute("id"));
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getCssValue("background-color"));
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getSize());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getLocation());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).getTagName());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isEnabled());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"gform_submit_button_1\"]")).isSelected());
	}

}
