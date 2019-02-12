package com.fortaf.elements.basic;

import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;

/**
 * Wraps a label on a html form with some behavior.
 */
public class LabelImpl extends ElementImpl implements Label {

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public LabelImpl(WebElement element) {
        super(element);
    }

    @Override
    public String getValue() {
        return getWrappedElement().getAttribute("for");
    }
}
