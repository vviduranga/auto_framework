package com.fortaf.testng;

import org.testng.IExecutionListener;

public class FORTAFExecutionListener implements IExecutionListener{

		@Override
	    public void onExecutionStart() {
	       System.out.println("This method will be called right before starting the execution");
	    }
		

	    public void onExecutionFinish() {
	        System.out.println("This method will be called right after execution is finished");
	    }
	}

