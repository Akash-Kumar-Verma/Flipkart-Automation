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
import flipkart.Pages.Fashion;

public class FashionPageTest extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	@Test
	public void FashionTest() {
		String testName = "FashionTest";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		Fashion fashion = new Fashion(driver);

		// For closing the login Banner
		fashion.CloseLoginBanner();
		logger.info(" For closing the login Banner");

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger.info("wait");

		// Click on the Fashion Banner
		fashion.ClickOnFashionButton();
		extentTest.log(LogStatus.INFO, "Click on the Fashion Banner");
		logger.info("Click on the Fashion Banner");

		System.out.println(driver.getTitle());
		logger.info("print title");

		// In the Fashion field click on all type..
		fashion.ClickOnAllTypeButton();
		;
		extentTest.log(LogStatus.INFO, "In the In the Fashion field click on all type..");
		logger.info(" In the In the Fashion field click on all type..");

		// click on all type button
		fashion.ClickOnAllTypeButton();
		extentTest.log(LogStatus.INFO, "click on all type button..");
		logger.info(" click on all type button..");

		// click on Shirt button
		fashion.CLickedOnShirt();
		extentTest.log(LogStatus.INFO, "click on shirt button..");
		logger.info("click on shirt button..");

		// Assertions
		Assert.assertEquals(driver.getTitle(), "Fashion");
		logger.info(" print title");

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
