package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextBoxImpl.class)
public interface TextBox extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}
