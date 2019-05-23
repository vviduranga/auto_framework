package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in UIElement functionality.
 */
@ImplementedBy(UIElementImpl.class)
public interface UIElement extends Element {

    
}
