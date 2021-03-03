package SwiggyCucumberStepDefinition;

import org.junit.Assert;

import SwiggyPOI.SwiggyExcelData;
import SwiggyPageAndMethod.SwiggyCheckout;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwiggyBillCheck 
{
	String FileLocationTestStatus = "C:\\\\Users\\\\ansig\\\\eclipse-workspace\\\\SwiggyProject\\\\SwiggyLiveMenuData.xlsx";
	String TestStatusSheetName = "TestStatus";
	int Teststatusrow = 1;
	SwiggyExcelData TestStatusRead = new SwiggyExcelData();
	SwiggyCheckout LiveBillTotal = new SwiggyCheckout(null);
	
	@Given("^User has add menu items into Swiggy site$")
	public void user_has_add_menu_items_into_Swiggy_site() throws Throwable 
	{
		if (TestStatusRead.SwiggyTestStatusRead(FileLocationTestStatus, TestStatusSheetName, Teststatusrow).equalsIgnoreCase("PASS"))
		{
			Assert.assertTrue(true);
			System.out.println("User has added menu items into Swiggy Site :: PASS");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("User has added menu items into Swiggy Site :: FAIL");
		}	
	}

	@Given("^Menu list and price are added into excelsheets$")
	public void menu_list_and_price_are_added_into_excelsheets() throws Throwable 
	{
		if (TestStatusRead.SwiggyTestStatusRead(FileLocationTestStatus, TestStatusSheetName, Teststatusrow).equalsIgnoreCase("PASS"))
		{
			Assert.assertTrue(true);
			System.out.println("Menu list and price are added into excelsheets :: PASS");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Menu list and price are added into excelsheets :: FAIL");
		}
	}

	@When("^Total Bill has been generated$")
	public void total_Bill_has_been_generated() throws Throwable
	{
		if (TestStatusRead.SwiggyTestStatusRead(FileLocationTestStatus, TestStatusSheetName, Teststatusrow).equalsIgnoreCase("PASS"))
		{
			Assert.assertTrue(true);
			System.out.println("Total Bill has been generated :: PASS");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Total Bill has been generated :: FAIL");
		}
	}

	@Then("^I validate the correctness of total bill value$")
	public void i_validate_the_correctness_of_total_bill_value() throws Throwable 
	{
		int CheckTotalLiveBill = LiveBillTotal.MenuBillTotal;
		int [] ExcelTotalBill = TestStatusRead.SwiggyBillCheck(FileLocationTestStatus, "LiveMenu", 1);
		int TotalExcelBill = ExcelTotalBill[0] + ExcelTotalBill[1]+ExcelTotalBill[2];
		if (CheckTotalLiveBill==TotalExcelBill)
		{
			Assert.assertTrue(true);
			System.out.println("Total Bill: " + TotalExcelBill);
			System.out.println("I validate the correctness of total bill value :: PASS");
		}
		else
		{
			System.out.println("I validate the correctness of total bill value :: FAIL");
			System.out.println("Expected Bill Amount: " + TotalExcelBill);
			System.out.println("Actual Bill Amount: " + CheckTotalLiveBill);
			Assert.assertTrue(false);

		}

	}


}
