package SwiggyPageAndMethod;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import SwiggyPOI.SwiggyExcelData;

public class SwiggyRestaurantMenu 
{
	WebDriver  driver;
	String[][] RestaurantMenuExcelData = new String[10][10];
	String[][] RestaurantLiveMenuList = new String[5][2];
	SwiggyExcelData MenuDataReadWrite = new SwiggyExcelData();
	
	public SwiggyRestaurantMenu(WebDriver driver) 
	{
		this.driver=driver;
	}

	public boolean MenuExcelDataRead() throws InterruptedException, IOException
	{				
		try 
		{
			this.RestaurantMenuExcelData = MenuDataReadWrite.SwiggyMenuDataRead("C:\\Users\\ansig\\eclipse-workspace\\SwiggyProject\\SwiggyProjectData.xlsx", "SwiggyRestaurant", 1);
			return true;
		} 
		catch (Exception e) 
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
			return false;
		}		
	}

	//Webelement Declaration
	private By AddItem = By.xpath("//*[@id=\"modal-placeholder\"]//div/span[@class=\"_38xdN\" and contains(text(),\"Add Item\")]");

	// Adding Menu based on excel data
	public boolean RestaurantMenu() throws InterruptedException, IOException
	{			
		try 
		{
			Thread.sleep(2000);
			List <WebElement> SearchMenuList = driver.findElements(By.cssSelector("span.styles_itemNameText__3bcKX"));
			List <WebElement> SearchMenuPrice = driver.findElements(By.cssSelector("span.rupee"));
			List <WebElement> AddMenu = driver.findElements(By.cssSelector("div._1RPOp"));
			int ProductSize = 0;
			ProductSize = SearchMenuList.size();	
			System.out.println("Menu Count: " + ProductSize);
			int menucount = 0;
			int i = 0;
			int j = 0;
			for(WebElement menulist : SearchMenuList)
			{	
				if (i==3)
				{
					System.out.println("Menu Selection Complete");
					break;
				}
				if (RestaurantMenuExcelData[i+1][j].trim().equals(menulist.getText().trim()))
				{				
					RestaurantLiveMenuList[i][j] = menulist.getText();
					//Menu Price
					RestaurantLiveMenuList[i][j+1] = SearchMenuPrice.get(menucount).getText();
					System.out.println("Menu: " +RestaurantLiveMenuList[i][j]+ " Price: "+ RestaurantLiveMenuList[i][j+1]);
					Thread.sleep(2000);
					AddMenu.get(menucount).click();
					Thread.sleep(2000);
					WebElement element = driver.findElement(AddItem);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					++i;
				}
				menucount++;
			}
			System.out.println("Swiggy ADD Menu :: PASSED");
			return true;
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			System.out.println("Swiggy Menu Element not found");
			return false;
		}
	}
	
	// Saving Live Data from Swiggy Application to Excel 
	public boolean MenuExcelDataWrite() throws InterruptedException, IOException
	{				
		try 
		{
			boolean WriteResult = MenuDataReadWrite.SwiggyMenuDataWrite("C:\\Users\\ansig\\eclipse-workspace\\SwiggyProject\\SwiggyLiveMenuData.xlsx", "LiveMenu", 1, RestaurantLiveMenuList);
			if (WriteResult) 
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Could not write into the Excel sheet");
			e.printStackTrace();
			return false;
		}		
	}	
}
