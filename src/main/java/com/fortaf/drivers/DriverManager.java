package com.fortaf.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
//	
//	public static WebDriver driver;
//	
//	/**
//	 * Get the required browser using WebDriver Manager
//	 * @param browser
//	 * @return the WebDriver
//	 */
//	public static synchronized WebDriver getBrowser(String browser){
//		
//			if(browser.equalsIgnoreCase("chrome")){
//				WebDriverManager.chromedriver().setup() ;
//				driver = new ChromeDriver();
//			}
//			else if(browser.equalsIgnoreCase("firefox")){
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			}
//			else if(browser.equalsIgnoreCase("ie")){
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
//			}
//			else if(browser.equalsIgnoreCase("edge")){
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//			}
//			return driver;
//	}
	
	
	
	//--------------------
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	 
	
	public WebDriver getBrowser(String browser){
	
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			setDriver(new InternetExplorerDriver());
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			setDriver(new EdgeDriver());
		}
		return driver.get();
	}
	
	
    public static WebDriver driver() {
        return driver.get();
    }
 
    static void setDriver(WebDriver webdriver) {
        driver.set(webdriver);
    }
    
	
	
	/**
	 * References:
	 * 1. https://www.swtestacademy.com/selenium-parallel-tests-grid-testng/
	 * 2. https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/
	 * 3/ https://stackoverflow.com/questions/49819021/parallel-execution-of-selenium-script-on-one-physical-machine
	 */
	
}
