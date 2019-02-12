package com.fortaf.elements.basic;

import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;

/**
 * Wrapper class that wraps basic link functionality.
 */
public class LinkImpl extends ElementImpl implements Link {

    /**
     * Wraps a WebElement with link functionality.
     *
     * @param element to wrap up
     */
	public LinkImpl(WebElement element) {
		super(element);
	}
	
}
