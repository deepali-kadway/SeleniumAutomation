package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class css_selectors {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.get("https://thirdeyecreations.co.in/shops/create");
	//	CSS Selector Basic Syntax & Select by ID
		driver.findElement(By.cssSelector("input#password_confirmation")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
		
	// Select by CLASS
	//syntax for class is: tagname.elementid or basic syntax: tagname[attributename = 'value']
	//But class attribute usually has common values in multiple fields, so we combine them to find one element.
		driver.findElement(By.cssSelector("input.form-control[name='seller_name']")).sendKeys("Deepali");
	// in above, we have first identified class attribute then passed another attribute for uniqueness.

	//another way of combining the CSS Selectors
		driver.findElement(By.cssSelector("input.form-control[class='form-control'][name='email']")).sendKeys("Test");
		
	// CSS Selectors Substring matching for dynamic values	
		driver.get("https://www.salesforce.com/form/signup/elf-v2-login/?d=70130000000Enus");
		driver.findElement(By.cssSelector("input[id^='UserFirstName']")).sendKeys("Deepali"); //prefix
		driver.findElement(By.cssSelector("input[name$='UserEmail']")).sendKeys("test@gmail.com"); //suffix
		driver.findElement(By.cssSelector("input[id*='LastName']")).sendKeys("Kadway"); //substring
		
	//CSS Selectors: CHILD and SUBCHILD. (>) is for child () is for child & subchild
	//As below, select is parent and option is child
		driver.findElement(By.cssSelector("select[name='CompanyCountry']>option[value='AL']")).click();
		
	//CSS Selector: Next/Adjacent sibling, provided both have same parent. will only select second sibling.
		driver.findElement(By.cssSelector("option[label='Employees']+option[value='10']")).click();
		
	//CSS Selector: PSEUDO CLASS
		driver.findElement(By.cssSelector("select[name='CompanyCountry']>:last-child")).click();
		driver.findElement(By.cssSelector("select[name='CompanyEmployees']>:nth-child(3)")).click();
	
		
		
		
		
		
		
		
	}


}
