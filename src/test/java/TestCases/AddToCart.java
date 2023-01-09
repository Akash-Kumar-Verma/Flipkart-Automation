package TestCases;

import java.time.Duration;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Automation.Utilities.ReadingPropertiesFile;
import Utilities.BaseClass;
import Utilities.HelperClass;
import flipkart.Pages.AddToCartPage;

public class AddToCart extends BaseClass {
	private String sheetName = ReadingPropertiesFile.getProperty("ProductPageSheetName");
	@Test
	public void addtoCard() {
		
		String testName = "addtoCard";
		// start the extent report
		extentTest = extentReport.startTest(testName, testName + " started");

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// if execution required field is no
		HelperClass.toCheckExecutionRequired(executionRequired);
		
		AddToCartPage addtocart=new AddToCartPage(driver);
		
		//click on close Banner
		addtocart.CloseLoginBanner();
		extentTest.log(LogStatus.INFO,"Close the Banner..");
		logger.info("Close the Banner..");

		addtocart.ClickOnSearchBox();
		extentTest.log(LogStatus.INFO, "search box is clicked and SearchItem is  serached");
		logger.info("search box is clicked and SearchItem is  serached");

		addtocart.ClickOnSearchButton();
		extentTest.log(LogStatus.INFO, "serach button is clicked");
		logger.info("serach button is clicked");

		addtocart.CLickedOnItem();
		extentTest.log(LogStatus.INFO, "first result is clicked on the screen");
		logger.info("first result is clicked on the screen");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info(" wait...");

		//driver.get(ReadingPropertiesFile.getProperty("url_iphone"));
		System.out.println("url_iphone");

		addtocart.clickonaddTocart();
		extentTest.log(LogStatus.INFO, "the item is succesfully added to cart");
		logger.info(" the item is succesfully added to cart");

		System.out.println("added To Cart");
		logger.info(" the item is succesfully added to cart");

	}
}
