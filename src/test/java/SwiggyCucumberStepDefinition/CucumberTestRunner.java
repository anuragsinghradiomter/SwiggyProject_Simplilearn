package SwiggyCucumberStepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ="C:\\Users\\ansig\\eclipse-workspace\\SwiggyProject\\src\\test\\resources\\Features"
, glue = {"SwiggyCucumberStepDefinition"}
, plugin = {"pretty", "html:target/SwiggyCucumberReport"}
) 
public class CucumberTestRunner extends AbstractTestNGCucumberTests
{

}
