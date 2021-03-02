package SwiggyTestNGSuite;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import SwiggyPageAndMethod.SwiggyCheckout;
import SwiggyPageAndMethod.SwiggyHomePage;
import SwiggyPageAndMethod.SwiggySearchPage;
import SwiggyTestListener.SwiggyListener;
import SwiggyPageAndMethod.SwiggyRestaurantMenu;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;

@Listeners(SwiggyListener.class)

public class SwiggyTest 
{
	WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extenttest;

	@Parameters(value = {"browserType"})
	@BeforeTest
	public void setup(String browserType ) throws MalformedURLException
	{
		DesiredCapabilities dr=null;
		System.out.println(browserType);     
		if(browserType.equals("chrome"))
		{
			dr=DesiredCapabilities.chrome();
			dr.setBrowserName("chrome");
			dr.setPlatform(Platform.WINDOWS);    
		}
		else if(browserType.equals("ie"))
		{
			dr=DesiredCapabilities.internetExplorer();
			dr.setBrowserName("iexplore");
			dr.setPlatform(Platform.WINDOWS);
		}  

		URL myRURL = new URL("http://192.168.0.100:4444/wd/hub"); 
		driver = new RemoteWebDriver(myRURL, dr);

		//Extent Report Section
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/SwiggyTestSuiteReport.html");
		htmlReporter.config().setDocumentTitle("Swiggy Test Suite Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Browser Type: ", browserType);
		extentReport.setSystemInfo("Operating System: ", "Win 10 OS");

	}

	@AfterTest
	public void tearDown()
	{
		extentReport.flush();
		driver.quit();
	}

	@Test
	public void SwiggyHome() throws InterruptedException, IOException 
	{	
		extenttest = extentReport.createTest("SwiggyHome");
		SwiggyHomePage SwiggyHome = new SwiggyHomePage(driver);
		boolean ActResult1 = SwiggyHome.SwiggyCities();
		Assert.assertEquals(true, ActResult1);
		boolean ActResult2 = SwiggyHome.SwiggyCityLocation();
		Assert.assertEquals(true, ActResult2);
	}

	@Test(dependsOnMethods={"SwiggyHome"})
	public void SwiggySearch() throws InterruptedException, IOException 
	{	
		extenttest = extentReport.createTest("SwiggySearch");
		SwiggySearchPage SearchSwiggy = new SwiggySearchPage(driver);
		boolean ActResult1 = SearchSwiggy.SwiggySearch();
		Assert.assertEquals(true, ActResult1);
		boolean ActResult2 = SearchSwiggy.SwiggySearchRestaurant();
		Assert.assertEquals(true, ActResult2);
	}

	@Test(dependsOnMethods={"SwiggySearch"})
	public void SwiggyRestaurantMenu() throws InterruptedException, IOException 
	{	
		extenttest = extentReport.createTest("SwiggyRestaurantMenu");
		SwiggyRestaurantMenu SwiggyMenu = new SwiggyRestaurantMenu(driver);		
		boolean ActResult1 = SwiggyMenu.MenuExcelDataRead();
		Assert.assertEquals(true, ActResult1);
		boolean ActResult2 = SwiggyMenu.RestaurantMenu();
		Assert.assertEquals(true, ActResult2);
		boolean ActResult3 = SwiggyMenu.MenuExcelDataWrite();
		Assert.assertEquals(true, ActResult3);
	}

	@Test(dependsOnMethods={"SwiggyRestaurantMenu"})
	public void SwiggyRestaurantCheckout() throws InterruptedException, IOException 
	{	
		extenttest = extentReport.createTest("SwiggyRestaurantCheckout");
		SwiggyCheckout MenuCheckout = new SwiggyCheckout(driver);		
		boolean ActResult1 = MenuCheckout.RestaurantCheckout();
		Assert.assertEquals(true, ActResult1);
		boolean ActResult2 = MenuCheckout.CheckoutBillDetails();
		Assert.assertEquals(true, ActResult2);
	}

	@AfterMethod
	public void ExtentResultReporter(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			extenttest.log(Status.FAIL, "Test Case: " + result.getName() + " is FAILED");
			extenttest.log(Status.FAIL, "Test Case Error: " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			extenttest.log(Status.SKIP, "Test Case: " + result.getName() + " is SKIPPED");
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			extenttest.log(Status.PASS, "Test Case: " + result.getName()+ " is PASS");
		}
	}
}
