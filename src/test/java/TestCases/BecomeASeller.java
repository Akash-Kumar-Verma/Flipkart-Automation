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
import flipkart.Pages.BecomeASellerPage;

public class BecomeASeller extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	
	@Test
	public void BecomeASellerTest() {
		
		String testName = "BecomeASellerTest";
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

		BecomeASellerPage becomeaseller = new BecomeASellerPage(driver);

		// For closing the login Banner
		becomeaseller.CloseLoginBanner();
		logger.info("For closing the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("for wait");

		// Click on the Beacome A Seller Banner
		becomeaseller.ClickOnSellerButton();
		extentTest.log(LogStatus.INFO, "Click on the Beacome A Seller Banner");
		logger.info("Click on the Beacome A Seller Banner");

		System.out.println(driver.getTitle());
		logger.info("print driver title");

		// In the Mobile Number field Mobile Number is Send..
		becomeaseller.SendMobileNumber();
		extentTest.log(LogStatus.INFO, "In the Mobile Number field Mobile Number is Send..");
		logger.info(" In the Mobile Number field Mobile Number is Send..");

		// click on Start Selling button
		becomeaseller.ClickonStartSellingButton();
		extentTest.log(LogStatus.INFO, "click on Start Selling button..");
		logger.info("click on Start Selling button..");

		// Again fill the Mobile Number
		becomeaseller.EnterAgainMobileNumber();
		extentTest.log(LogStatus.INFO, "In the Mobile Number field Mobile Number is again filled..");
		logger.info(" Results NotMatched;Test Case Failed");

		// Again fill the Email ID
		becomeaseller.sendEmailId();
		extentTest.log(LogStatus.INFO, "Again fill the Email ID ");
		logger.info(" Again fill the Email ID ");

		// Again final click on Register and Continue
		becomeaseller.ClickOnReginster();
		extentTest.log(LogStatus.INFO, "final click on Register and Continue.");
		logger.info(" final click on Register and Continue.");

		// Assertions
		Assert.assertEquals(driver.getTitle(), "Seller Dashboard");
		logger.info(" Seller Dashboard");

		if (driver.getTitle().contains("")) {
			System.out.println("Results Matched;Test Case Passed");
			logger.info(" Results Matched;Test Case Failed");
		} else {
			ScreenShots.takeScreenShot(driver, "AppliancesError");
			System.out.println("Results NotMatched;Test Case Failed");
			logger.info(" Results NotMatched;Test Case Failed");
		}

	}

}
