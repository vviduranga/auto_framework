package com.ztaf.elements.widget;

import com.ztaf.elements.base.Element;
import com.ztaf.elements.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextInputImpl.class)
public interface TextInput extends Element {
    /**
     * @param text The text to type into the field.
     */
    void set(String text);
}
