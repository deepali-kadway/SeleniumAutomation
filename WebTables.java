package ui;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://www.asx.com.au/markets/trade-our-cash-market/equity-market-prices?utm_widget=topTwenty");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		/* Move To the required WebElement which consists the table */
		WebElement scroll = driver
				.findElement(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[8]/td[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(scroll);
		action.perform();

		/* Get the number of rows and columns */

		List<WebElement> rowelements = driver
				.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr"));
		System.out.println(rowelements.size());
		int rowsize = rowelements.size();

		List<WebElement> colelements = driver
				.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[2]/td"));
		System.out.println(colelements.size());
		int colsize = colelements.size();

		/* Iterate the rows and columns to get the text and print it */
		for (int i = 2; i <= rowsize; i++) {
			for (int j = 1; j <= colsize; j++) {
				
				System.out.print(driver.findElement(By.xpath(
						"//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[" + i + "]/td[" + j + "]"))
						.getText()+ " ");
			}
			System.out.println();
		}

	}

}
