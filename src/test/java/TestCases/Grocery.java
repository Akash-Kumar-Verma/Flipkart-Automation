package TestCases;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Automation.Utilities.ScreenShots;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.GroceryPage;

public class Grocery extends BaseClass {

	private String sheetName = ReadingPropertiesFile.getProperty("GroceryPageSheetName");

	@Test(priority=1)
	public void GroceryTestForValidLocationAndValidSearch() throws InterruptedException {

		String testName = "GroceryTestForValidLocationAndValidSearch";

		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		System.out.println("testData->" + testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String Location = testData.get("Input Location");
		String items = testData.get("Input Items");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// for page factory
		GroceryPage grocery = new GroceryPage(driver);

		// close the login Banner
		grocery.CloseLoginBanner();
		logger.info(" close the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("wait");

		// navigate to grocery page
		grocery.ClickOnGroceryButton();
		extentTest.log(LogStatus.INFO, "Grocery button is clicked.");
		logger.info(" Grocery button is clicked.");

		// Enter the Delivery Location
		grocery.SendThePinCode(Location);
		logger.info(" Enter the Delivery Location");

		// send the data on search items
		grocery.SendItemsOnSearchBox(items);
		logger.info("send the data on search items");

		grocery.clickonSRCButton();
		extentTest.log(LogStatus.INFO, "Rice is search in SearchBar and clicked.");
		logger.info("Rice is search in SearchBar and clicked.");

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(),
				"Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com");
		System.out.println(driver.getTitle());
		logger.info("print the driver title");

		if (driver.getTitle().contains("Grocery")) {
			System.out.println("Results Matched;Test Case Passed");
			logger.info(" Results Matched;Test Case Passed");
		} else {
			ScreenShots.takeScreenShot(driver, "Error");
			System.out.println("Results Not Matched;Test Case Failed");
			logger.info(" Results Not Matched;Test Case Failed");
		}
	}

	@Test(priority=2)
	public void GroceryTestForInValidLocationAndValidSearch() throws InterruptedException {

		String testName = "GroceryTestForInValidLocationAndValidSearch";

		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		System.out.println("testData->" + testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String Location = testData.get("Input Location");
		String items = testData.get("Input Items");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// for page factory
		GroceryPage grocery = new GroceryPage(driver);

		// close the login Banner
		grocery.CloseLoginBanner();
		logger.info(" close the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("wait");

		// navigate to grocery page
		grocery.ClickOnGroceryButton();
		extentTest.log(LogStatus.INFO, "Grocery button is clicked.");
		logger.info(" Grocery button is clicked.");

		// Enter the Invalid Delivery Location
		grocery.SendThePinCode(Location);
		logger.info(" Enter the Delivery Location");

		// send the data on search items
		grocery.SendItemsOnSearchBox(items);
		logger.info("send the data on search items");

		grocery.clickonSRCButton();
		extentTest.log(LogStatus.INFO, "Rice is search in SearchBar and clicked.");
		logger.info("Rice is search in SearchBar and clicked.");

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(),
				"Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com");
		System.out.println(driver.getTitle());
		logger.info("print the driver title");

		if (driver.getTitle().contains("Grocery")) {
			System.out.println("Results Matched;Test Case Passed");
			logger.info(" Results Matched;Test Case Passed");
		} else {
			ScreenShots.takeScreenShot(driver, "Error");
			System.out.println("Results Not Matched;Test Case Failed");
			logger.info(" Results Not Matched;Test Case Failed");
		}
	}

	@Test(priority=3)
	public void GroceryTestForValidLocationAndInValidSearch() throws InterruptedException {

		String testName = "GroceryTestForValidLocationAndInValidSearch";

		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		System.out.println("testData->" + testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String Location = testData.get("Input Location");
		String items = testData.get("Input Items");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// for page factory
		GroceryPage grocery = new GroceryPage(driver);

		// close the login Banner
		grocery.CloseLoginBanner();
		logger.info(" close the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("wait");

		// navigate to grocery page
		grocery.ClickOnGroceryButton();
		extentTest.log(LogStatus.INFO, "Grocery button is clicked.");
		logger.info(" Grocery button is clicked.");

		// Enter the Delivery Location
		grocery.SendThePinCode(Location);
		logger.info(" Enter the Delivery Location");

		// send the data on search items
		grocery.SendItemsOnSearchBox(items);
		logger.info("send the data on search items");

		grocery.clickonSRCButton();
		extentTest.log(LogStatus.INFO, "Rice is search in SearchBar and clicked.");
		logger.info("Rice is search in SearchBar and clicked.");

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(),
				"Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com");
		System.out.println(driver.getTitle());
		logger.info("print the driver title");

		if (driver.getTitle().contains("Grocery")) {
			System.out.println("Results Matched;Test Case Passed");
			logger.info(" Results Matched;Test Case Passed");
		} else {
			ScreenShots.takeScreenShot(driver, "Error");
			System.out.println("Results Not Matched;Test Case Failed");
			logger.info(" Results Not Matched;Test Case Failed");
		}
	}

	@Test(priority=4)
	public void GroceryTestForInInValidLocationAndInValidSearch() throws InterruptedException {

		String testName = "GroceryTestForInInValidLocationAndInValidSearch";

		// ----------------------- Test Starts
		// --------------------------------------------------
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		System.out.println("testData->" + testData);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String Location = testData.get("Input Location");
		String items = testData.get("Input Items");
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// for page factory
		GroceryPage grocery = new GroceryPage(driver);

		// close the login Banner
		grocery.CloseLoginBanner();
		logger.info(" close the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("wait");

		// navigate to grocery page
		grocery.ClickOnGroceryButton();
		extentTest.log(LogStatus.INFO, "Grocery button is clicked.");
		logger.info(" Grocery button is clicked.");

		// Enter the Delivery Location
		grocery.SendThePinCode(Location);
		logger.info(" Enter the Delivery Location");

		// send the data on search items
		grocery.SendItemsOnSearchBox(items);
		logger.info("send the data on search items");

		grocery.clickonSRCButton();
		extentTest.log(LogStatus.INFO, "Rice is search in SearchBar and clicked.");
		logger.info("Rice is search in SearchBar and clicked.");

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(),
				"Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com");
		System.out.println(driver.getTitle());
		logger.info("print the driver title");

		if (driver.getTitle().contains("Grocery")) {
			System.out.println("Results Matched;Test Case Passed");
			logger.info(" Results Matched;Test Case passed");
		} else {
			ScreenShots.takeScreenShot(driver, "Error");
			System.out.println("Results Not Matched;Test Case Failed");
			logger.info(" Results Not Matched;Test Case Failed");
		}
	}
}
