package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(linkText = "My Account")
	public WebElement myAccount;

	@FindBy(linkText = "Login")
	public WebElement login;

	@FindBy(id = "input-email")
	public WebElement email;

	@FindBy(id = "input-password")
	public WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[4]")
	public WebElement addressBook;

	@FindBy(linkText = "New Address")
	public WebElement newAddress;

	@FindBy(id = "input-firstname")
	public WebElement firstName;

	@FindBy(id = "input-lastname")
	public WebElement lastName;

	@FindBy(id = "input-address-1")
	public WebElement address1;

	@FindBy(id = "input-city")
	public WebElement city;

	@FindBy(id = "input-postcode")
	public WebElement postCode;

	@FindBy(id = "input-country")
	public WebElement country;

	@FindBy(id = "input-zone")
	public WebElement region;

	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement successMessage;
}