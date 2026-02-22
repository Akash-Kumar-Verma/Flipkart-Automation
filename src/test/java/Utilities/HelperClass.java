package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;

// have methods needed by docker
public class HelperClass extends BaseClass {

	// variables needed by all methods
	public static WebDriver webDriver;

	private static final String browserName = ReadingPropertiesFile.getProperty("browser").toLowerCase();

	public HelperClass() throws Exception {

		// check for browser name
		if (browserName.equals("chrome") || browserName.equals("firefox") || browserName.equals("ie")) {

			logger.info("Browser supported");
		} else {

			System.out.println(browserName);
			logger.error("Browser not supported");
			throw new Exception("Browser not supported");
		}
	}

	public static WebDriver toRunBrowserOnLocal(boolean headlessMode) {

		if (headlessMode) {

			webDriver = startBrowserInHeadless();
			logger.info(browserName + " in headless mode initiated");
		}

		else {

			webDriver = startBrowserInNonHeadless();
			logger.info(browserName + " in non headless mode  initiated");
		}

		return webDriver;
	}

	public static WebDriver startBrowserInHeadless() {

		ChromeOptions chromeOptions = null;
		FirefoxOptions firefoxOptions = null;
		InternetExplorerOptions ieOptions = null;

		if (browserName.equals("chrome")) {
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			chromeOptions.addArguments("window-size=1920,1080");
			chromeOptions.addArguments("user-agent=Chrome/88.0.4324.150");
			webDriver = new ChromeDriver(chromeOptions);
		}

		else if (browserName.equals("firefox")) {
			firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("headless");
			firefoxOptions.addArguments("window-size=1920,1080");
			webDriver = new FirefoxDriver(firefoxOptions);
		}

		else if (browserName.equals("ie")) {
			ieOptions = new InternetExplorerOptions();

			logger.info("IE doesn't support headless mode .... starting normal");
			webDriver = new InternetExplorerDriver(ieOptions);
		}

		return webDriver;
	}

	// To start different browsers in nonheadless
	public static WebDriver startBrowserInNonHeadless() {

		if (browserName.equals("chrome")) {
			webDriver = new ChromeDriver();
			logger.info("Chrome driver initiated in head mode");
		}

		else if (browserName.equals("firefox")) {
			webDriver = new FirefoxDriver();
			logger.info("Firefox driver initiated in head mode");

		}

		else if (browserName.equals("ie")) {
			webDriver = new InternetExplorerDriver();
			logger.info("IE driver initiated in head mode");
		}

		return webDriver;
	}

	public static void toCheckExecutionRequired(String executionRequired) {

		// if execution required field is no
		if (executionRequired.equals("no")) {
			extentTest.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			logger.info("Execution required is no , skipping the test");
		}

		// if execution required field is empty
		if (executionRequired.equals("")) {
			extentTest.log(LogStatus.WARNING, "Execution Required : " + executionRequired.toUpperCase());
			logger.info("Execution required is empty , skipping the test");
		}
	}
}
