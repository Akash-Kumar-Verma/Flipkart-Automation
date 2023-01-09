package TestCases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.Productsearch;

@Test
public class ProductSearch extends BaseClass {

	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");

	@Test(priority = 1)
	@SuppressWarnings("deprecation")
	public void ValidProductSearch() throws InterruptedException {

		String testName = "ValidProductSearch";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");
		String input=testData.get("Input");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		driver.findElement(Productsearch.close_btn).click();
		logger.info("close Banner is button was clicked");
		extentTest.log(LogStatus.INFO, "close Banner is button was clicked");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		// search the product
		driver.findElement(Productsearch.search_Box).sendKeys(input);
		logger.info("search valid keyword is send");
		extentTest.log(LogStatus.INFO, "search box is clicked and mobile is searched");
		// click on search button

		driver.findElement(Productsearch.search_Btn).click();
		logger.info("after searching first result is got clicked");
		extentTest.log(LogStatus.INFO, "after searching first result is got clicked");

		// Get Product Name
		String ProductName = driver.findElement(Productsearch.productname).getText();
		logger.info("get the product details..");
		extentTest.log(LogStatus.INFO, "get the product details..");

		System.out.println(ProductName);

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(), expectedTitle);

		if (driver.getTitle().contains("Mobile")) {
			System.out.println("Results Matched;Test Case Passed");
		} else {
			System.out.println("Results NotMatched;Test Case Failed");
		}

	}

	@Test(priority = 2)
	public void InvalidProductSearch() throws InterruptedException {

		String testName = "InvalidProductSearch";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");
		String input=testData.get("Input");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		// Test
		driver.findElement(Productsearch.close_btn).click();
		logger.info("close Banner is button was clicked");
		extentTest.log(LogStatus.INFO, "close Banner is button was clicked");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		// search the product
		driver.findElement(Productsearch.search_Box).sendKeys(input);
		logger.info("search invalid keyword is send");
		extentTest.log(LogStatus.INFO, "search box is clicked and invalid keyword is searched");
		// click on search button

		driver.findElement(Productsearch.search_Btn).click();
		logger.info("after searching first result is got clicked");
		extentTest.log(LogStatus.INFO, "after searching first result is got clicked");

		// Get Product Name
		String ProductName = driver.findElement(Productsearch.productname).getText();
		logger.info("get the product details..");
		extentTest.log(LogStatus.INFO, "get the product details..");

		System.out.println(ProductName);

		// Verify that correct Product is displaying after search

		Assert.assertEquals(driver.getTitle(),
				"Mobile- Buy Products Online at Best Price in India - All Categories | Flipkart.com");

		if (driver.getTitle().contains("Mobile")) {
			System.out.println("Results Matched;Test Case Passed");
		} else {
			System.out.println("Results NotMatched;Test Case Failed");
		}

	}

}
