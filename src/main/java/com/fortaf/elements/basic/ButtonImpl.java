package com.fortaf.elements.basic;

import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;

/**
 * Wrapper class that wraps basic button functionality.
 */
public class ButtonImpl extends ElementImpl implements Button {

    /**
     * Wraps a WebElement with button functionality.
     *
     * @param element to wrap up
     */
	public ButtonImpl(WebElement element) {
		super(element);
	}
	
}
