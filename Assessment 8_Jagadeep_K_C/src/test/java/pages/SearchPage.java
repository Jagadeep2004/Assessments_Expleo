package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "search")
	public WebElement searchBar;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@class='product-thumb']")
	public WebElement validProduct;

	@FindBy(xpath = "//*[@id='content']/p[2]")
	public WebElement invalidSearchMessage;

}