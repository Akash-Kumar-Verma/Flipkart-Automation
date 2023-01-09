package TestCases;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.MobileViewPage;

public class MobileView extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	@Test
	public void MobileviewTest() {
		String testName = "MobileviewTest";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		MobileViewPage mobileview = new MobileViewPage(driver);

		mobileview.CloseLoginBanner();

		// Using Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// search the product
		mobileview.ClickOnMobileButton();
		extentTest.log(LogStatus.INFO, "Mobile box is clicked.");
		// click on search button

		// Get Product Name
		String ProductName = mobileview.getProductDetalis();
		System.out.println(ProductName);

		// Verify that correct Product is displaying after search
		Assert.assertEquals(driver.getTitle(), "Mobile Phones Online at Best Prices in India");

		System.out.println(driver.getTitle());

		if (driver.getTitle().contains("Mobile")) {
			System.out.println("Results Matched;Test Case Passed");
		} else {
			System.out.println("Results NotMatched;Test Case Failed");
		}
	}

}
