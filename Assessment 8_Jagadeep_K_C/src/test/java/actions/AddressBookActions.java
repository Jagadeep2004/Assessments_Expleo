package actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.AddressBookPage;

public class AddressBookActions extends BaseActions {

	AddressBookPage page;

	public AddressBookActions(WebDriver driver) {

		super(driver);

		page = new AddressBookPage(driver);
	}

	public void loginApplication() {

		page.myAccount.click();

		page.login.click();

		page.email.sendKeys("r.am@gmail.com");

		page.password.sendKeys("ram@123");

		page.loginButton.click();
	}

	public void navigateToAddressBook() {

		page.addressBook.click();

		page.newAddress.click();
	}

	public void enterAddressDetails(
			Map<String, String> data) {

		page.firstName.sendKeys(data.get("firstName"));

		page.lastName.sendKeys(data.get("lastName"));

		page.address1.sendKeys(data.get("address1"));

		page.city.sendKeys(data.get("city"));

		page.postCode.sendKeys(data.get("postCode"));

		Select country =
				new Select(page.country);

		country.selectByVisibleText(
				data.get("country"));

		Select region =
				new Select(page.region);

		region.selectByVisibleText(
				data.get("region"));

		page.continueButton.click();
	}

	public boolean successMessageDisplayed() {

		return page.successMessage.isDisplayed();
	}
}