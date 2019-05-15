package com.fortaf.testng;

import static com.fortaf.drivers.DriverManager.driver;
import static com.fortaf.test.config.ContextParam.BASE_URL;
import static com.fortaf.test.config.ContextParam.BROWSER;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fortaf.annotations.TestConfig;
import com.fortaf.drivers.DriverManager;
import com.fortaf.reports.BasicExtentReport;
import com.fortaf.test.config.TestContext;

public class FORTAFTestListener implements ITestListener, IInvokedMethodListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub		

	}

//	@Override
//	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//
//		BasicExtentReport.logTestCase(method.getTestMethod().getMethodName());
//
//		// If annotation is present
//		if (TestConfig.class!=null || testResult.getInstance().getClass().isAnnotationPresent(TestConfig.class)) {
//
//			if (method.isTestMethod()) {
//				System.out.println("Start Executing Test: " + method.getTestMethod().getMethodName());
//				TestConfig config = testResult.getInstance().getClass().getAnnotation(TestConfig.class);
//				/** Start the browser **/
//				DriverManager manager = new DriverManager();
//				manager.getBrowser(config.browser().toString());
//				System.out.println(config.baseUrl());
//				driver().navigate().to(config.baseUrl());
//			}
//		}
//	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		BasicExtentReport.logTestCase(method.getTestMethod().getMethodName());

		// If annotation is present
		if (testResult.getInstance().getClass().isAnnotationPresent(TestConfig.class)) {

			if (method.isTestMethod()) {
				System.out.println("Start Executing Test: " + method.getTestMethod().getMethodName());
				setTestConfigParamsToContext(testResult);
				
				/** Start the browser **/
				DriverManager manager = new DriverManager();
				manager.getBrowser(TestContext.get(BROWSER).toString());
				System.out.println(TestContext.get(BASE_URL).toString());
				driver().navigate().to(TestContext.get(BASE_URL).toString());
			}
		}
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		BasicExtentReport.getResult(testResult, driver());
		
		if (method.isTestMethod() && !driver().equals(null)) {
			System.out.println("Finished Executing Test: " + method.getTestMethod().getMethodName());
			driver().close();
		}
	}

	/**
	 * Set test config parameters to context
	 * @param testResult
	 */
	public void setTestConfigParamsToContext(ITestResult testResult) {
		TestConfig configAnnotation = testResult.getInstance().getClass().getAnnotation(TestConfig.class);

		if (isTestConfigAnnoationPresent(testResult)) {
			TestContext.setIfNotExist(BROWSER, configAnnotation.browser().toString());
			TestContext.setIfNotExist(BASE_URL, configAnnotation.baseUrl().toString());
			// TODO: Add any other default parameters
		}
	}
	
	public boolean isTestConfigAnnoationPresent(ITestResult testResult){
		if (testResult.getInstance().getClass().isAnnotationPresent(TestConfig.class))
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * References: 1.
	 * https://www.toolsqa.com/selenium-webdriver/testng-listeners/
	 */
}
