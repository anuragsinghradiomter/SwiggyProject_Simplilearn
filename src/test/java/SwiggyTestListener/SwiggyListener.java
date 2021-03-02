package SwiggyTestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SwiggyListener implements ITestListener
{
	public void onTestStart(ITestResult result)
	{
		System.out.println("*** Test Scenario: " + result.getName() +  " has STARTED ***");
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("### Test Scenario: " + result.getName() + " has PASSED ###" + "\n");
	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("??? Test Scenario: " + result.getName()+ " has FAILED ???" + "\n");
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("^^^ Test Scenario: " + result.getName()+ " has SKIPPED ^^^" + "\n");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("~~~ Swiggy Test Suite Execution Finished ~~~");
	}
}
