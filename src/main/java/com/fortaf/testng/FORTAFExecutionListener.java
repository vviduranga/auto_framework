package com.fortaf.testng;

import org.testng.IExecutionListener;

import com.fortaf.reports.BasicExtentReport;

public class FORTAFExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionStart() {
		System.out.println("This method will be called right before starting the execution");
		System.out.println("Starting Extent Report");
		BasicExtentReport.startReport();
	}

	@Override
	public void onExecutionFinish() {
		System.out.println("This method will be called right after execution is finished");
		BasicExtentReport.endReport();
	}
}
