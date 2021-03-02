package SwiggyCucumberStepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwiggyBillCheck 
{
	@Given("^User has add menu items into Swiggy site$")
	public void user_has_add_menu_items_into_Swiggy_site() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User has add menu items into Swiggy site");
	}

	@Given("^Menu list and price are added into excelsheets$")
	public void menu_list_and_price_are_added_into_excelsheets() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Menu list and price are added into excelsheets");
	}

	@When("^Total Bill has been generated$")
	public void total_Bill_has_been_generated() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Total Bill has been generated");
	}

	@Then("^I validate the correctness of total bill value$")
	public void i_validate_the_correctness_of_total_bill_value() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("I validate the correctness of total bill value");
	}


}
