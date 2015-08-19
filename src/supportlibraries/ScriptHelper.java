package supportlibraries;

import org.openqa.selenium.WebDriver;

import com.cognizant.framework.CraftliteDataTable;
import com.cognizant.framework.selenium.SeleniumReport;


/**
 * Wrapper class for common framework objects, to be used across the entire test case and dependent libraries
 * @author Cognizant
 */
public class ScriptHelper
{
	private final CraftliteDataTable dataTable;
	private final SeleniumReport report;
	private final WebDriver driver;
	
	/**
	 * Constructor to initialize all the objects wrapped by the {@link ScriptHelper} class
	 * @param dataTable The {@link CraftliteDataTable} object
	 * @param report The {@link SeleniumReport} object
	 * @param driver The {@link WebDriver} object
	 */
	public ScriptHelper(CraftliteDataTable dataTable, SeleniumReport report, WebDriver driver)
	{
		this.dataTable = dataTable;
		this.report = report;
		this.driver = driver;
	}
	
	/**
	 * Function to get the {@link CraftliteDataTable} object
	 * @return The {@link CraftliteDataTable} object
	 */
	public CraftliteDataTable getDataTable()
	{
		return dataTable;
	}
	
	/**
	 * Function to get the {@link SeleniumReport} object
	 * @return The {@link SeleniumReport} object
	 */
	public SeleniumReport getReport()
	{
		return report;
	}
	
	/**
	 * Function to get the {@link WebDriver} object
	 * @return The {@link WebDriver} object
	 */
	public WebDriver getDriver()
	{
		return driver;
	}
}