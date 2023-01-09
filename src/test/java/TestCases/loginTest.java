package TestCases;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.loginPage;

public class loginTest extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	
	//Test for Valid Mobile Number
	@Test(priority=1)
	public void LoginUsingValidDataTest() {
		
		String testName = "LoginUsingValidDataTest";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");
		String mobNo = testData.get("Input");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		loginPage loginpage = new loginPage(driver);

		// Click on the Close Banner
		loginpage.CloseLoginBanner();

		// Click on the Login Button
		loginpage.ClickOnLogIn();
		extentTest.log(LogStatus.INFO, "Login Button  is clicked");

		// On the login Section Mobile number is filled..
		loginpage.EnterMobileNumber(mobNo);
		extentTest.log(LogStatus.INFO, "In the Output Box Mobile Number is Send.");

		// Clicked on the Request OTP Button
		loginpage.RequestOTP();
		extentTest.log(LogStatus.INFO, "clicked on the Request OTP Button");

	}

	//Test for Invalid Mobile Number
	@Test(priority=2)
	public void LoginWithInvalidDataTest() {
		
		String testName = "LoginWithInvalidDataTest";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");
		String mobNo = testData.get("Input");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);

		loginPage loginpage = new loginPage(driver);

		// Click on the Close Banner
		loginpage.CloseLoginBanner();

		// Click on the Login Button
		loginpage.ClickOnLogIn();
		extentTest.log(LogStatus.INFO, "Login Button  is clicked");

		// On the login Section Mobile number is filled..
		loginpage.EnterMobileNumber(mobNo);
		extentTest.log(LogStatus.INFO, "In the Output Box Mobile Number is Send.");

		// Clicked on the Request OTP Button
		loginpage.RequestOTP();
		extentTest.log(LogStatus.INFO, "clicked on the Request OTP Button");

	}

}
