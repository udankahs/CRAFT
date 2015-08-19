package testscripts.scenario1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.DriverScript;
import supportlibraries.TestCase;
import functionallibraries.FunctionalLibrary;


/**
 * Test for login with invalid user credentials
 * @author Cognizant
 */
public class TC2 extends TestCase
{
	private FunctionalLibrary functionalLibrary;
	
	@Test
	public void runTC2()
	{
		testParameters.setCurrentTestDescription("Test for login with invalid user credentials");
		testParameters.setBrowser(Browser.Chrome);
		
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	@Override
	public void setUp()
	{
		functionalLibrary = new FunctionalLibrary(scriptHelper);
		report.addTestLogSection("Setup");
		
		driver.get(properties.getProperty("ApplicationUrl"));
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
								properties.getProperty("ApplicationUrl"), Status.DONE);
	}
	
	@Override
	public void executeTest()
	{
		functionalLibrary.login();
		
		// Verify login for invalid user
		WebDriverUtil driverUtil = new WebDriverUtil(driver);
		if(!driverUtil.objectExists(By.linkText("SIGN-OFF"))) {
			report.updateTestLog("Verify Login", "Login failed for invalid user", Status.PASS);
		} else {
			report.updateTestLog("Verify Login", "Login succeeded for invalid user", Status.FAIL);
			functionalLibrary.logout();
		}
	}
	
	@Override
	public void tearDown()
	{	
		// Nothing to do
	}
}