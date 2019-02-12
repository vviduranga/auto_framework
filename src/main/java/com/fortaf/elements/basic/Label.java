package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Html form label.
 */
@ImplementedBy(LabelImpl.class)
public interface Label extends Element {
    /**
     * Gets the for attribute on the label.
     *
     * @return string containing value of the for attribute, null if empty.
     */
    String getValue();
}
