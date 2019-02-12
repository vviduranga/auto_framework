package com.ztaf.elements.helpers;

import org.openqa.selenium.WebDriver;

import com.fortaf.elements.factory.api.ElementFactory;

public class BasePage {

	public BasePage() {
		// TODO Auto-generated constructor stub
	}
    /**
     * Static factory for generating the class.
     *
     * @param driver The WebDriver for the session.
     * @return FormTestObject.
     */
    public static FormTestObject initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, FormTestObject.class);
    }
    
}
