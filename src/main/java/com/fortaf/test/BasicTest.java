package com.fortaf.test;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.fortaf.framework.core.WebActions;
import com.fortaf.reports.BasicExtentReport;

public class BasicTest {

	@BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite: before suite");
    }       
     
    @BeforeTest
    public void beforeTest(ITestContext context) {
        System.out.println("@BeforeTest: before test");       
        BasicExtentReport.logTestCase(context.getAllTestMethods()[0].getMethodName());
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest: after test");	       
    }
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass: before class");
    }
     
    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass: after class");
    }
    
    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite: after suite");
    }
    
    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("@BeforeMethod: before method");
        System.out.println(method.getName());
    }
    
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        System.out.println("@afterMethod: after method");
        BasicExtentReport.getResult(testResult, WebActions.driver);	    
    }
}
