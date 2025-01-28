package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//public static interface WebDriver.Navigation;

public class BasicMethodsSelenium {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");

		driver.manage().window().maximize();

		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		String title = driver.getTitle();
		System.out.println(title);

		String pagesource = driver.getPageSource();
		System.out.println(pagesource);

		driver.navigate().to("https://thirdeyecreations.co.in/");

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		List<WebElement> webelements = driver.findElements(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		System.out.println(webelements);
		
		driver.navigate().to("https://www.sugarcrm.com/");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		
/*		driver.findElement(By.xpath("//*[@id=\"slide-6792b59265fd9\"]/div/div/div[1]/div/div/div[1]/div/a")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
*/				
		driver.close();

	}

}
