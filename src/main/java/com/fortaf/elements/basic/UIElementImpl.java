package com.fortaf.elements.basic;

import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;

/**
 * UIElement wrapper.
 */
public class UIElementImpl extends ElementImpl implements UIElement {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public UIElementImpl(WebElement element) {
        super(element);
    }
}
