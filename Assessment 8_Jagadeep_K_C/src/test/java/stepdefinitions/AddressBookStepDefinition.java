package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import actions.AddressBookActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressBookStepDefinition {

	AddressBookActions actions;

	@Given("User logs into the application")
	public void user_logs_into_the_application() {

		actions = new AddressBookActions(Hooks.driver);

		actions.loginApplication();
	}

	@When("User navigates to Address Book page")
	public void user_navigates_to_address_book_page() {

		actions.navigateToAddressBook();
	}

	@When("User enters address details")
	public void user_enters_address_details(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		actions.enterAddressDetails(data);
	}

	@Then("Address should be added successfully")
	public void address_should_be_added_successfully() {

		assertTrue(actions.successMessageDisplayed());
	}
}