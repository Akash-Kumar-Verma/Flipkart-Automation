package Automation.Utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtendManager {
	private static ExtentReports extend;

	public static ExtentReports getInstance(String filename) {
		if (extend == null) {

			extend = new ExtentReports(filename, true, DisplayOrder.NEWEST_FIRST);

			extend.loadConfig(new File(System.getProperty("user.dir") + "//resource//reportConfig.xml"));

			extend.addSystemInfo("Selenium Version", "4.3.0").addSystemInfo("Environment", "QA");

		}
		return extend;

	}

}
