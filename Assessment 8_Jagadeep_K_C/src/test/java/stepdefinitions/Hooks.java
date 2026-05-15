package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");
	}

	@After
	public void tearDown() {

		if (driver != null) {

			driver.quit();

			driver = null;
		}
	}
}