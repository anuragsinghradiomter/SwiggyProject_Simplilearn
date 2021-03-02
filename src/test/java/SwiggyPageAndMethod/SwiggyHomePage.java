package SwiggyPageAndMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import SwiggyPOI.SwiggyExcelData;

public class SwiggyHomePage 
{
	WebDriver  driver;
	String[] DeliveryLocation = new String[2]; 
	public SwiggyHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean SwiggyData() throws InterruptedException, IOException
	{			
			SwiggyExcelData LocationInput = new SwiggyExcelData();
			try 
			{
				this.DeliveryLocation = LocationInput.SwiggyLocationData("C:\\Users\\ansig\\eclipse-workspace\\SwiggyProject\\SwiggyProjectData.xlsx", "SwiggyDeliveryLocation", 1);
				return true;
			} 
			catch (Exception e) 
			{
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
				return false;
			}		
	}

	private By SwiggyCitiesLink = By.linkText("Bangalore");
	private By SwiggyCityLocalityBtn = By.xpath("//*[@id=\"root\"]//div[@class=\"Iou1H\" and contains(text(), \"Enter street name, area etc...\")]");
	private By SwiggyCityLocalityText = By.xpath("//*[@id=\"overlay-sidebar-root\"]//div/input[@type=\"text\"]");
	private By SwiggyLocalitySelection = By.xpath("//*[@id=\"overlay-sidebar-root\"]//div[contains(text(), \"Koramangala\") and @class=\"Ku2oK\"]");
	
	public boolean SwiggyCities() throws InterruptedException, IOException
	{	
		try 
		{
			driver.get("https://www.swiggy.com/");
			Thread.sleep(3000);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(SwiggyCitiesLink).click();
			System.out.println("Swiggy Location Clicked");
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy City Element not found");
			System.out.println("Test Step :: Swiggy City Not Found :: FAILED");
			return false;
		}
	}
	
	public boolean SwiggyCityLocation() throws InterruptedException, IOException
	{	
		try 
		{
			Thread.sleep(2000);
			driver.findElement(SwiggyCityLocalityBtn).click();
			Thread.sleep(2000);
			driver.findElement(SwiggyCityLocalityText).sendKeys("Koramangala");
			Thread.sleep(2000);
			driver.findElement(SwiggyLocalitySelection).click();
			System.out.println("Swiggy City Location Clicked");
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Swiggy City Locality Element not found");
			System.out.println("Test Step :: Swiggy City Locality Not Found :: FAILED");
			return false;
		}
	}
		
	public void closedriver()
	{
		driver.close();
	}

}
