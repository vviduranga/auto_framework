package com.fortaf.annotations;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGAnnotationHandler implements ITestListener {

	
	@Override
    public void onTestStart(ITestResult result) {
		
		// If annotation is 
		if(result.getInstance().getClass().isAnnotationPresent(TestConfig.class)){
			
		}
		
		TestConfig config = result.getInstance().getClass().getAnnotation(TestConfig.class);
		System.out.println(config.browser().name()); 
	}



	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
