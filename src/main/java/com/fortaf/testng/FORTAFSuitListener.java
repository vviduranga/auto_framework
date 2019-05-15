package com.fortaf.testng;

import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.fortaf.test.config.TestContext;

public class FORTAFSuitListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		/* Get all TestNG TestPlan Parameters */
		//TestCommons.setTestPlanParameters(suite.getXmlSuite().getAllParameters());
		
		
		System.out.println(suite.getXmlSuite().getAllParameters());
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
	}

	public void setTestPlanParametersToContext(ISuite suite){
		Map<String, String> params = suite.getXmlSuite().getAllParameters();
		
		// Add all test plan params to test context
		
		
	}
	
	/**
	 * References: 1.
	 * https://www.toolsqa.com/selenium-webdriver/testng-listeners/
	 */
}
