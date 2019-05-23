package com.fortaf.elements.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import static com.fortaf.framework.core.WebActions.*;

import com.fortaf.framework.core.JSActions;
import com.fortaf.framework.core.WaitHandler;

/**
 * An implementation of the Element interface. Delegates its work to an underlying WebElement instance for
 * custom functionality.
 */
public class ElementImpl implements Element {

    private final WebElement element;

    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public ElementImpl(final WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void clear() {
		element.clear();
		if (element.getText().length() > 0) {
			JSActions.clearByJS(element);
		}
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public Coordinates getCoordinates() {
        return ((Locatable) element).getCoordinates();
    }

    @Override
    public boolean elementWired() {
        return (element != null);
    }

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return element.getRect();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return element.getScreenshotAs(arg0);
	}
	
	/** Wait Functions **/
	
	@Override
	public void waitToBeDisplayed(){
		WaitHandler.waitToBeDisplayed(element);		
	}
	
	@Override
	public void waitToBeDisplayed(int timeoutInSeconds){
		WaitHandler.waitToBeDisplayed(element, timeoutInSeconds);		
	}

	@Override
	public void waitToBeClickable(){
		WaitHandler.waitToBeClickable(element);
	}
	
	@Override
	public void waitToBeClickable(int timeOutInSeconds){
		WaitHandler.waitToBeClickable(element, timeOutInSeconds);
	}
	
	@Override
	public void waitToBeHidden(){
		WaitHandler.waitToBeHidden(element);
	}
	
	@Override
	public void waitToBeHidden(int timeOutInSeconds){
		WaitHandler.waitToBeHidden(element, timeOutInSeconds);
	}
		
	@Override
	public void waitForAnyText(int timeOutInSeconds){
		WaitHandler.waitForAnyText(element, timeOutInSeconds);
	}
	
	@Override
	public void waitForContainText(String text, int timeOutInSeconds){
		WaitHandler.waitForContainText(element, text, timeOutInSeconds);
	}

	/** Additional functions **/
	@Override
	public void rightClick() {		
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	@Override
	public void doubleClick() {
		element.click();
		element.click();		
	}

	@Override
	public void clickByJS() {
		JSActions.clickByJS(element);
	}
	
	
}

/**
 * 1. https://falkenfighter.wordpress.com/2013/10/29/access-the-by-class-created-using-findby-annotation-in-selenium/
 * 
 */
