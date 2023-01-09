package Utilities;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Automation.Utilities.ScreenShots;

public class BaseClass {

	// To initialize, select(Firefox, Chrome, IE), open and quit browser.
	public static WebDriver driver;

	public static ExtentReports extentReport;
	public static ExtentTest extentTest;

	// Log4j logger
	public final static Logger logger = Logger.getLogger(BaseClass.class);

	// Excel File Test Data Reader
	public static ExcelFileIO reader = null;

	// Creating and using Excel file
	static {

		try {
			// for Log4j Logger
			String log4jPath = System.getProperty("user.dir") + "//resource//log4j.properties";
			PropertyConfigurator.configure(log4jPath);
			// Exception Handling for Excel File
			reader = new ExcelFileIO(ReadingPropertiesFile.getProperty("testDataFileLocation"));
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
	}

	@BeforeMethod
	public void initDriver() {

		boolean headlessMode = Boolean.parseBoolean(ReadingPropertiesFile.getProperty("headlessMode"));

		if (headlessMode) {
			System.out.println("---- headless---");

			driver = HelperClass.startBrowserInHeadless();
		} else {
			System.out.println("---- Nonheadless---");

			driver = HelperClass.startBrowserInNonHeadless();
		}

		// Maximize the window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		extentReport = Automation.Utilities.ExtendManager.getInstance("reports//AutomationExtentReport.html");

	}

	@BeforeMethod
	public void navigateToURL() {
		driver.get(ReadingPropertiesFile.getProperty("url"));
		logger.info(ReadingPropertiesFile.getProperty("url") + " page opened...");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		// for fail test cases
		if(result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.FAIL, "TEST FAILED "+result.getName());
			extentTest.log(LogStatus.FAIL, "TEST FAILED THROWABLE EXC "+result.getThrowable());

			// adding screenshot
			String screenshotPath = ScreenShots.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}

		else if(result.getStatus() == ITestResult.SKIP) {

			extentTest.log(LogStatus.SKIP, "TEST SKIPPED "+result.getName());
		}

		else if(result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(LogStatus.PASS, "TEST PASSED "+result.getName());
		}

		// end the testcase in the extent report
		extentReport.endTest(extentTest);

		// closing the driver
		driver.quit();
		logger.info("Browser closed...");
	}


	@AfterTest
	public void endReport() {
		// tearing down extent report
		extentReport.flush();
		extentReport.close();
	}

}
