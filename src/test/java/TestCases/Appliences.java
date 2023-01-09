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
import flipkart.Pages.AppliencesPage;

public class Appliences extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	@Test
	public void AppliencesTest() {
		
		String testName = "AppliencesTest";
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
		
		AppliencesPage appliance=new AppliencesPage(driver);
		
		// For closing the login Banner
		appliance.CloseLoginBanner();
		logger.info("For closing the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info(" for wait");

		// search the product
		appliance.ClickOnAppliances();
		extentTest.log(LogStatus.INFO, "Appliences box is clicked.");
		logger.info("Appliences box is clicked.");

		System.out.println(driver.getTitle());
		logger.info(" print the driver title..");

		appliance.ClickOnSearchBox(input);
		logger.info(" search box is clicked and  searched");
		extentTest.log(LogStatus.INFO, "search box is clicked  is searched");
		// click on search button

		appliance.clickOnSearchButton();
		extentTest.log(LogStatus.INFO, "after searching first result is got clicked");
		logger.info("after searching first result is got clicked");

		// Get Product Name
		String ProductName = appliance.getProductName();
		System.out.println(ProductName);
		logger.info(" print the product description ");

		// Verify that correct Product is displaying after search
		System.out.println(driver.getTitle());
		logger.info(" Assertion");
		Assert.assertEquals(driver.getTitle().substring(0, 18), "TVs- Buy Products ");

		if (driver.getTitle().contains("Tvs")) {
			logger.info(" Results Matched;Test Case Passed");
			System.out.println("Results Matched;Test Case Passed");
		} else {
			ScreenShots.takeScreenShot(driver, "AppliancesError");
			System.out.println("Results NotMatched;Test Case Failed");
			logger.info(" Results NotMatched;Test Case Failed");
		}
	}
}
