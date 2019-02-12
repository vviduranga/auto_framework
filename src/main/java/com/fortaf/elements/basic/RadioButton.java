package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in Radio Button functionality.
 */
@ImplementedBy(RadioButtonImpl.class)
public interface RadioButton extends Element {

    /**
     * Click on the Radio Button
     */
    void click();
    
    /**
     * Get the selected status
     */
    void getStatus();

}
