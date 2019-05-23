package com.fortaf.reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fortaf.framework.util.DateUtil;

public class BasicExtentReport {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest logger;

	
	/**
	 * Starts the Extent Report by generating the required prerequisites like report folders, unique report file
	 * Run before all the tests 
	 * @param reportName Report file name
	 */
	public static void startReport(String reportName) {
		
		/* Create a report file */
		String reportFolderPath = System.getProperty("user.dir") + "/reports/";
		String reportPath = reportFolderPath + reportName + ".html";
		System.out.println("Report Path : " + reportPath);

		/* Create folder if not exist */
		File file = new File(reportPath);
        try {
        	file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();	
		}
        		
        /* Start Extent Reporter */
		htmlReporter = new ExtentHtmlReporter(reportPath);// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Fortude (Pvt) Ltd");
		htmlReporter.config().setDocumentTitle("Fortude Test Automation Report"); // Name of the report
		htmlReporter.config().setReportName("Fortude Test Automation Report"); // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);		
	}
	
	/**
	 * Starts the Extent Report by generating the required prerequisites like report folders, unique report file
	 * Run before all the tests 
	 */
	public static void startReport() {
		String reportName = getTestReportId();
		startReport(reportName);
	}
	
	/**
	 * This method is to capture the screenshot and return the path of the screenshot.
	 */
	private static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	/**
	 * Log the test name to report
	 * @param testName Test Name
	 */
	public static void logTestCase(String testName){
		logger = extent.createTest(testName);
	}
	
	//@AfterMethod
	public static void getResult(ITestResult result, WebDriver driver){
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case FAILED", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
			String screenshotPath;
			try {
				screenshotPath = getScreenShot(driver, result.getName());
				//To add it in the extent report 
				logger.fail("Test Case Failed Snapshot is below: " + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE)); 
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	//@AfterTest
	public static void endReport() {
		extent.flush();
	}
	
	private static String getTestReportId(){
		return "FORTAF Test Report - "  + DateUtil.currentDate("dd_MM_yyyy HH_mm_ss").toString();
	}
	
}
