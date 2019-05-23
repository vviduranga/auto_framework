package com.fortaf.elements.basic;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextBoxImpl.class)
public interface TextBox extends Element {
    /**
     * Type the text into the field.
     * @param text The text to type into the field.
     */
	void type(String text);
	
    /**
     * Forcefully type the text into the field.
     * @param text The text to type into the field.
     */
	void typeByJS(String text);

	void typeAppend(String text);
}
