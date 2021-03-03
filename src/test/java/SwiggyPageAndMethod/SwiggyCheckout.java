package SwiggyPageAndMethod;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SwiggyCheckout 
{
	WebDriver  driver;
	public static int MenuBillTotal;
	public SwiggyCheckout(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By CartCheckout = By.xpath("//*[@id=\"menu-content\"]//div[@class=\"_1gPB7\"]");
	
	public boolean RestaurantCheckout() throws InterruptedException, IOException
	{	
		try 
		{
			Thread.sleep(2000);
			driver.findElement(CartCheckout).click();
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy Checkout Element not found");
			return false;
		}
	}
	
	public boolean CheckoutBillDetails() throws InterruptedException, IOException
	{	
		try 
		{
			Thread.sleep(2000);
			List <WebElement> BillDetails = driver.findElements(By.cssSelector("span.ZH2UW"));
			MenuBillTotal = Integer.parseInt(BillDetails.get(0).getText());
			System.out.println("Item Total: " + MenuBillTotal);
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy Bill Element not found");
			return false;
		}
	}
	
	
}
