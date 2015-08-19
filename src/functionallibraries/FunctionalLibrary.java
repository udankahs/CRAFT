package functionallibraries;

import org.openqa.selenium.By;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;


/**
 * Functional Library class
 * @author Cognizant
 */
public class FunctionalLibrary extends ReusableLibrary
{
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public FunctionalLibrary(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	public void login()
	{
		String userName = dataTable.getData("General_Data","Username");
		String password = dataTable.getData("General_Data","Password");
		
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		report.updateTestLog("Login", "Enter login credentials: " +
										"Username = " + userName + ", " +
										"Password = " + password, Status.DONE);
	}
	
	public void verifyLoginValidUser()
	{
		WebDriverUtil driverUtil = new WebDriverUtil(driver);
		if(driverUtil.objectExists(By.linkText("SIGN-OFF"))) {
			report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS);
		} else {
			frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Verify Login", "Login failed for valid user");
		}
	}
	
	public void logout()
	{
		driver.findElement(By.linkText("SIGN-OFF")).click();
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
	}
}