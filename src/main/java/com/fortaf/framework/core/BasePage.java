package com.fortaf.framework.core;

import static com.fortaf.drivers.DriverManager.driver;

import org.openqa.selenium.WebDriver;

import com.fortaf.elements.factory.api.ElementFactory;

public class BasePage {

	protected WebDriver driver;

	public BasePage() {
		this.driver = driver();
		ElementFactory.initElements(driver, this);
	}
}
