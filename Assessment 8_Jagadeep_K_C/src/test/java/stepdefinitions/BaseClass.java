package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;

	public void launchBrowser() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");
	}

	public void closeBrowser() {

		if (driver != null) {

			driver.quit();
		}
	}
}