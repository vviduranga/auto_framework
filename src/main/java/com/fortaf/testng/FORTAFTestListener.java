package com.fortaf.testng;

import static com.fortaf.framework.drivers.DriverManager.driver;
import static com.fortaf.test.config.ContextParam.*;
import java.lang.annotation.Annotation;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.fortaf.framework.annotations.APITest;
import com.fortaf.framework.annotations.WebTest;
import com.fortaf.framework.drivers.DriverManager;
import com.fortaf.reports.BasicExtentReport;
import com.fortaf.test.config.TestContext;

public class FORTAFTestListener extends TestListenerAdapter implements IInvokedMethodListener {

	@Override
	public void onTestStart(ITestResult result) {
		super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		super.onTestSuccess(result);
		BasicExtentReport.getResult(result, driver());	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		super.onTestFailure(result);
		BasicExtentReport.getResult(result, driver());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		super.onTestSkipped(result);
		BasicExtentReport.getResult(result, driver());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		super.onTestFailedButWithinSuccessPercentage(result);

	}

	@Override
	public void onStart(ITestContext context) {
		super.onStart(context);

	}

	@Override
	public void onFinish(ITestContext context) {
		super.onFinish(context);	
		
//		if (driver() != null) {
//			driver().close();
//		}

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//		BasicExtentReport.logTestCase(method.getTestMethod().getMethodName());

		/* If WebTest annotation is present */
		if (WebTest.class!=null && testResult.getInstance().getClass().isAnnotationPresent(WebTest.class)) {
			setAnnotationParamsToContext(testResult, WebTest.class);

			/* Check if the driver is null, If NUll, initialize the driver */
			if (driver() == null) {
				System.out.println("Start Executing Test: " + method.getTestMethod().getMethodName());
				
				/** Start the browser **/
				DriverManager manager = new DriverManager();
				manager.getBrowser(TestContext.get(BROWSER).toString());
			}
		}
				
		/* If APITest Annotation is present */
		if (APITest.class!=null && testResult.getInstance().getClass().isAnnotationPresent(APITest.class)) {

			if (method.isTestMethod()) {
				System.out.println("Start Executing API Test: " + method.getTestMethod().getMethodName());
				setAnnotationParamsToContext(testResult, APITest.class);				
				//TODO :  API Test Implement here
			}
		}
	}
	
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {		
//		BasicExtentReport.getResult(testResult, driver());		
		if (method.isTestMethod() && driver() != null) {
			System.out.println("Finished Executing Test: " + method.getTestMethod().getMethodName());
			driver().close();
			driver().quit();
		}
	}

	/**
	 * Set test config parameters to context
	 * @param testResult
	 */
	public void setAnnotationParamsToContext(ITestResult testResult, Class<? extends Annotation> annotationClass) {
		Annotation annotation = testResult.getInstance().getClass().getAnnotation(annotationClass);

		if (isAnnoationPresent(testResult, WebTest.class)) {
			TestContext.setIfNotExist(BROWSER, ((WebTest) annotation).browser().toString());
			TestContext.setIfNotExist(BASE_URL, ((WebTest) annotation).baseUrl().toString());
			TestContext.setIfNotExist(PRIORITY, ((WebTest) annotation).priority().toString());
			// TODO: Add any other default parameters
		}
		
		if (isAnnoationPresent(testResult, APITest.class)) {
			TestContext.setIfNotExist(ENDPOINT_URL, ((APITest) annotation).endPointURL().toString());
			TestContext.setIfNotExist(PRIORITY, ((APITest) annotation).priority().toString());
			// TODO: Add any other default parameters
		}
	}
	
	/**
	 * Check if the given annotation is present
	 * @param testResult ITestResult
	 * @param annotationClass Annotation class
	 * @return true if Annotation is present
	 */
	public boolean isAnnoationPresent(ITestResult testResult, Class<? extends Annotation> annotationClass){
		if (testResult.getInstance().getClass().isAnnotationPresent(annotationClass))
			return true;
		else
			return false;
	}
	
	
	/**
	 * References: 1.
	 * https://www.toolsqa.com/selenium-webdriver/testng-listeners/
	 */
}
