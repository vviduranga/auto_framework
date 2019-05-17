package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Interface that wraps a WebElement in IFrame functionality.
 */
@ImplementedBy(IFrameImpl.class)
public interface IFrame extends Element {

}
