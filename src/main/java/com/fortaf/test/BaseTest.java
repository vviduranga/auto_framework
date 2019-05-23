package com.fortaf.test;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BasicTest{

	@BeforeSuite
    public void beforeSuite() {
        super.beforeSuite();
    }       
     
    @BeforeTest
    public void beforeTest(ITestContext context) {
        super.beforeTest(context);
    }
    
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }
     
    @AfterClass
    public void afterClass() {
        super.afterClass();
    }
    
    @AfterSuite
    public void afterSuite() {
        super.afterSuite();
    }
    
    @BeforeMethod
    public void beforeMethod(Method method) {
        super.beforeMethod(method);
    }
    
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
		super.afterMethod(testResult);
    }
}
