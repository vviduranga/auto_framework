package com.fortaf.testng;

import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.fortaf.test.config.TestContext;

public class FORTAFSuitListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		/* Set all TestNG TestPlan parameters to context */
		this.setTestPlanParametersToContext(suite);		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
	}

	/**
	 * Set all Suite Level test plan params to test context
	 * @param suite
	 */
	public void setTestPlanParametersToContext(ISuite suite) {		
		/* Set all Suite Level test plan params to test context	*/
		Map<String, String> testPlanParams = suite.getXmlSuite().getParameters();
		for (Map.Entry<String, String> entry : testPlanParams.entrySet()) {
			TestContext.set(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * References: 1.
	 * https://www.toolsqa.com/selenium-webdriver/testng-listeners/
	 */
}
