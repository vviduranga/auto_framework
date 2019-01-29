package com.ztaf.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver driver;
	
	/**
	 * Get the required browser using WebDriver Manager
	 * @param browser
	 * @return the WebDriver
	 */
	public WebDriver getBrowser(String browser){
		
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie")){
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			else if(browser.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			return driver;
	}
	
	
	
}
