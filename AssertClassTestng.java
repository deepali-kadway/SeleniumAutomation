package ui;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertClassTestng {

	@Test
	public void checktitle() {
		SoftAssert softassert = new SoftAssert();
		String expectedtitle = "Amazon.com. Spend less. Smile more.";
		String expectedtext = "Sell";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		String actualtitle = driver.getTitle();
		System.out.println("Verifying Title");
		softassert.assertEquals(actualtitle, expectedtitle, "Comparison check"); // assertion for checking Strings

		String actualtext = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]")).getText();
		System.out.println("Verifying Text");
		softassert.assertEquals(actualtext, expectedtext, "Comparison check");

		driver.close();
		softassert.assertAll();

	}
}
