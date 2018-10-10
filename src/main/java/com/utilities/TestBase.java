package com.utilities;

import java.io.File;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	static ExtentTest test;
	public static ExtentTest getTest() {
		return test;
	}

	public static void setTest(ExtentTest test) {
		TestBase.test = test;
	}

	static ExtentReports report;

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws Exception {

		WebDriverUtils.setTestName(method.getName());
		driver = WebDriverUtils.openBrowser();
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("Selenium Project");
	}

	@AfterMethod(alwaysRun = true)
	public static void tearDown(ITestResult result) throws Exception {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile,
						new File("C:\\Users\\vsingh\\eclipse-workspace\\Selenium\\defectScreenShots\\"
								+ result.getName() + ".jpeg"));
				Log.info(Environment.ReadExcelData("Global_Validater", 5, 1));
			}

		} catch (Exception x) {
			Log.error(x);
			Log.info(Environment.ReadExcelData("Global_Validater", 6, 1));
		} finally {
			if (driver != null) {
				try {
					driver.quit();
					Log.info(Environment.ReadExcelData("Global_Validater", 4, 1));
					report.endTest(test);
					report.flush();
				} catch (Exception x) {
					Log.error(x);
					Log.info(Environment.ReadExcelData("Global_Validater", 3, 1));
				}
			}

		}
	}

}
