package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.SearchPage;

public class SearchActions extends BaseActions {

	SearchPage searchPage;

	public SearchActions(WebDriver driver) {

		super(driver);

		searchPage = new SearchPage(driver);
	}

	public boolean searchBarDisplayed() {

		return driver.findElement(By.name("search")).isDisplayed();
	}

	public void searchProduct(String keyword) {

		driver.findElement(By.name("search")).clear();

		driver.findElement(By.name("search")).sendKeys(keyword);

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	public boolean validProductDisplayed() {

		return driver.findElement(By.xpath("//div[@class='product-thumb']")).isDisplayed();
	}

	public String getInvalidSearchMessage() {

		return driver.findElement(By.xpath("//*[@id='content']/p[2]")).getText();
	}
}