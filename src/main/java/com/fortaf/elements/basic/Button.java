package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in Button functionality.
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

    /**
     * Click on the Button
     */
    void click();

}
