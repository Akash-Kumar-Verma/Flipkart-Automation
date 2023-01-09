package TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.TravelPage;

public class Travel extends BaseClass {

	private String sheetName = ReadingPropertiesFile.getProperty("searchPageSheetName");

	@Test(priority=1)
	public void whenUserEntersValidFromAndValidTo() throws InterruptedException {

		String testName = "whenUserEntersValidFromAndValidTo";

		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		System.out.println("testData->" + testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		TravelPage travelpage = new TravelPage(driver);

		// for Closing the Login Banner
		travelpage.CloseLoginBanner();

		// Navigating to Travel Page
		travelpage.ClickOnTravelButton();

		// Enter the Location
		travelpage.enterFromLocation(fromLocation);
		logger.info(fromLocation + " was entered");
		extentTest.log(LogStatus.INFO, fromLocation + " was entered");

		// Enter the Location
		travelpage.enterToLocation(toLocation);
		logger.info(toLocation + " was entered");
		extentTest.log(LogStatus.INFO, toLocation + " was entered");

		/*
		 * searchPage.enterDate(dateVal); logger.info(dateVal + " date was entered");
		 * extentTest.log(LogStatus.INFO, dateVal + " date was entered");
		 */

		// Search Button is Clicked
		travelpage.ClickOnSearchButton();
		logger.info("search button was clicked");
		extentTest.log(LogStatus.INFO, "search button was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("ActualTitle :" + actualTitle);
		extentTest.log(LogStatus.INFO, "ActualTitle :" + actualTitle);

		System.out.println(driver.getTitle());

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

		// ----------------------- Test Ends
		// --------------------------------------------------
	}

	@Test(priority=2)
	public void whenUserEntersValidFromAndInvalidTo() throws InterruptedException {

		String testName = "whenUserEntersValidFromAndInvalidTo";
		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		TravelPage travelpage = new TravelPage(driver);

		// for Closing the Login Banner
		travelpage.CloseLoginBanner();

		// Navigating to Travel Page
		travelpage.ClickOnTravelButton();

		// Enter the Location
		travelpage.enterFromLocation(fromLocation);
		logger.info(fromLocation + " was entered");
		extentTest.log(LogStatus.INFO, fromLocation + " was entered");

		// Enter the Location
		travelpage.enterToLocation(toLocation);
		logger.info(toLocation + " was entered");
		extentTest.log(LogStatus.INFO, toLocation + " was entered");

		// Search Button is Clicked
		travelpage.ClickOnSearchButton();
		logger.info("search button was clicked");
		extentTest.log(LogStatus.INFO, "search button was clicked");

		String actualTitle = driver.getTitle();
		logger.info("Actual Title :" + actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :" + actualTitle);

		Assert.assertEquals(driver.getTitle(), actualTitle);

		// ----------------------- Test Ends
		// --------------------------------------------------
	}

	@Test(priority=3)
	public void whenUserEntersInvalidFromAndValidTo() throws InterruptedException {

		String testName = "whenUserEntersInvalidFromAndValidTo";
		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		TravelPage travelpage = new TravelPage(driver);

		// for Closing the Login Banner
		travelpage.CloseLoginBanner();

		// Navigating to Travel Page
		travelpage.ClickOnTravelButton();

		// Enter the Location
		travelpage.enterFromLocation(fromLocation);
		logger.info(fromLocation + " was entered");
		extentTest.log(LogStatus.INFO, fromLocation + " was entered");

		// Enter the Location
		travelpage.enterToLocation(toLocation);
		logger.info(toLocation + " was entered");
		extentTest.log(LogStatus.INFO, toLocation + " was entered");

		// Search Button is Clicked
		travelpage.ClickOnSearchButton();
		logger.info("search button was clicked");
		extentTest.log(LogStatus.INFO, "search button was clicked");

		String actualTitle = driver.getTitle();
		logger.info("Actual Title :" + actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :" + actualTitle);

		Assert.assertEquals(driver.getTitle(), actualTitle);

		// ----------------------- Test Ends
		// --------------------------------------------------
	}

	@Test(priority=4)
	public void whenUserEntersInvalidFromAndInValidTo() throws InterruptedException {

		String testName = "whenUserEntersInvalidFromAndInValidTo";
		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String fromLocation = testData.get("From");
		String toLocation = testData.get("To");
		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		TravelPage travelpage = new TravelPage(driver);

		// for Closing the Login Banner
		travelpage.CloseLoginBanner();

		// Navigating to Travel Page
		travelpage.ClickOnTravelButton();

		// Enter the Location
		travelpage.enterFromLocation(fromLocation);
		logger.info(fromLocation + " was entered");
		extentTest.log(LogStatus.INFO, fromLocation + " was entered");

		// Enter the Location
		travelpage.enterToLocation(toLocation);
		logger.info(toLocation + " was entered");
		extentTest.log(LogStatus.INFO, toLocation + " was entered");

		// Search Button is Clicked
		travelpage.ClickOnSearchButton();
		logger.info("search button was clicked");
		extentTest.log(LogStatus.INFO, "search button was clicked");

		String actualTitle = driver.getTitle();
		logger.info("Actual Title :" + actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title :" + actualTitle);

		Assert.assertEquals(driver.getTitle(), actualTitle);

		// ----------------------- Test Ends
		// --------------------------------------------------
	}

}
