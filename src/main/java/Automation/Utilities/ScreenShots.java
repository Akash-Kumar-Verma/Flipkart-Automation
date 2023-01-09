package Automation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public static void takeScreenShot(WebDriver driver, String fileName) {

		String screenshotFileName = System.getProperty("user.dir") + "\\FailedTestsScreenshots\\" + fileName + ".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, new File(screenshotFileName));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";

		// copying the screenshot
		File finalDestination = new File(destination);

		try {
			FileUtils.copyFile(source, finalDestination);
			return destination;
		} catch (Exception e) {

			// logger.error(e.getMessage());
			return null;
		}
	}

}
