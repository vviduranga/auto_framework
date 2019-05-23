package com.fortaf.elements.basic;

import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.ElementImpl;
import com.fortaf.framework.core.JSActions;

/**
 * TextInput  wrapper.
 */
public class TextBoxImpl extends ElementImpl implements TextBox {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public TextBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public void type(String text) {
        //WebElement element = getWrappedElement();
        super.clear();
        getWrappedElement().sendKeys(text);
    }

    @Override
    public void typeAppend(String text) {
        WebElement element = getWrappedElement();
        element.sendKeys(text);
    }
    
    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }

	@Override
	public void typeByJS(String text) {
		WebElement element = getWrappedElement();
		JSActions.sendKeysByJS(element, text);
	}
    
}
