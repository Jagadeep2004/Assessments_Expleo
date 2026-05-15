package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import actions.SearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinition {

	SearchActions searchActions;

	@Given("User is on home page")
	public void user_is_on_home_page() {

		searchActions = new SearchActions(Hooks.driver);
	}

	@Then("Search bar should appear")
	public void search_bar_should_appear() {

		assertTrue(searchActions.searchBarDisplayed());
	}

	@When("User searches {string}")
	public void user_searches(String keyword) {

		searchActions.searchProduct(keyword);
	}

	@Then("Valid products should appear")
	public void valid_products_should_appear() {

		assertTrue(searchActions.validProductDisplayed());
	}

	@Then("Invalid product message should appear")
	public void invalid_product_message_should_appear() {

		String expected =
			"There is no product that matches the search criteria.";

		assertEquals(
				searchActions.getInvalidSearchMessage(),
				expected);
	}
}