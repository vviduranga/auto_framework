package com.fortaf.elements.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * wraps a web element interface with extra functionality. Anything added here will be added to all descendants.
 */
@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable {
    /**
     * Returns true when the inner element is ready to be used.
     *
     * @return boolean true for an initialized WebElement, or false if we were somehow passed a null WebElement.
     */
    boolean elementWired();

    /**
     * Right click on the element 
     */
    void rightClick();
    
    /**
     * Click using {@link JavascriptExecutor}. Use this if the normal Click() doesn't work
     */
    void clickByJS();
        
    /**
     * Double click on element
     */
    void doubleClick();
    
	void waitToBeDisplayed();

	void waitToBeDisplayed(int timeoutInSeconds);

	void waitForAnyText(int timeOutInSeconds);

	void waitForContainText(String text, int timeOutInSeconds);

	void waitToBeClickable();

	void waitToBeClickable(int timeOutInSeconds);

	void waitToBeHidden();

	void waitToBeHidden(int timeOutInSeconds);

}
