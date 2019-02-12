package com.fortaf.elements.basic;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;

/**
 * Wrapper class that wraps basic RadioButton functionality.
 */
public class RadioButtonImpl extends ElementImpl implements RadioButton {

    /**
     * Wraps a WebElement with RadioButton functionality.
     *
     * @param element to wrap up
     */
    public RadioButtonImpl(WebElement element) {
        super(element);
    }

	@Override
	public void getStatus() {
		// TODO Auto-generated method stub
		throw new NotImplementedException("not implemented");
	}

}
