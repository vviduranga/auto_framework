package com.fortaf.framework.core;

import static com.fortaf.framework.drivers.DriverManager.driver;
import static com.fortaf.test.config.ContextParam.*;

import org.openqa.selenium.WebDriver;

import com.fortaf.test.config.TestContext;

public class WebActions {

	public static AlertHandler alert =  new AlertHandler(driver());
	public static IframeHandler iframe = new IframeHandler(driver());
	public static WindowHandler window = new WindowHandler(driver());
	
	public static String baseUrl = TestContext.get(BASE_URL);	
	public static String browser = TestContext.get(BROWSER);
	public static WebDriver driver =  TestContext.get(DRIVER);
	
	/**
	 * Go to baseUrl given in the @WebTest annotation
	 * or the value given in the testng.xml test plan
	 */
	public static void goToBaseURL(){
		driver().navigate().to(TestContext.get(BASE_URL).toString());
	}
	
	/**
	 * Go to a given url
	 */
	public static void goTo(String url){
		driver().navigate().to(url);
	}
	
	/**
	 * Pause the test execution for a given number of seconds
	 * @param seconds Number of seconds to wait
	 */
	public static void sleep(int seconds){
		WaitHandler.sleep(seconds);
	}
	
	
	public static void scroll(){
		//TODO: 
	}
	
	
	
}
