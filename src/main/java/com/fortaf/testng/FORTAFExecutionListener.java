package com.fortaf.testng;

import org.testng.IExecutionListener;

import com.fortaf.reports.BasicExtentReport;
import com.fortaf.test.config.TestContext;

public class FORTAFExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionStart() {
		System.out.println(this.getClass().getSimpleName() + "- onExecutionStart - This method will be called right before starting the execution");
		
		System.out.println("Starting Extent Report");
		BasicExtentReport.startReport();
		
		System.out.println("Starting Test Context");
		TestContext.initiate();
	}

	@Override
	public void onExecutionFinish() {
		System.out.println(this.getClass().getSimpleName() + "- onExecutionFinish - This method will be called right after execution is finished");
		
		System.out.println("Closing Extent Report");
		BasicExtentReport.endReport();
		
		System.out.println("Closing & Clearing Test Context");
		TestContext.clear();
	}
}
