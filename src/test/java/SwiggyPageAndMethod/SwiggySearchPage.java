package SwiggyPageAndMethod;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwiggySearchPage 
{
	WebDriver  driver;
	public SwiggySearchPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By SwiggySearchLink = By.linkText("Search");
	private By SwiggySearchInput = By.xpath("//*[@id=\"root\"]//div/input[@type=\"text\" and @class=\"_2BJMh\"]");
	private By SwiggySelectRestaurant = By.xpath("//*[@id=\"root\"]//div//span[contains(text(), \"Burger King\")]");
	private By SwiggyRestaurant = By.xpath("//*[@id=\"root\"]//div/a//div/img[@alt=\"Burger King\"]");
	
	public boolean SwiggySearch() throws InterruptedException, IOException
	{	
		try 
		{
			Thread.sleep(2000);
			driver.findElement(SwiggySearchLink).click();
			System.out.println("Swiggy Search Clicked");
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy Search Element not found");
			System.out.println("Test Step :: Swiggy Search :: FAILED");
			return false;
		}
	}
	
	public boolean SwiggySearchRestaurant() throws InterruptedException, IOException
	{	
		try 
		{
			Thread.sleep(2000);
			driver.findElement(SwiggySearchInput).sendKeys("BurgerKing");
			Thread.sleep(2000);
			driver.findElement(SwiggySelectRestaurant).click();
			Thread.sleep(2000);
			//driver.findElement(SwiggyRestaurant).click();
			WebElement element = driver.findElement(SwiggyRestaurant);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			System.out.println("Swiggy Search Restaurant Clicked");
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy Search Restaurant Element not found");
			System.out.println("Test Step :: Swiggy Search Restaurant :: FAILED");
			return false;
		}
	}
	
	public void closedriver()
	{
		driver.close();
	}
}
