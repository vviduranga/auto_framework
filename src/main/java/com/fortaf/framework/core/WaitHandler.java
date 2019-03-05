package com.fortaf.framework.core;

import static com.fortaf.drivers.DriverManager.driver;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {

	private static final Logger logger = Logger.getLogger(WaitHandler.class);

    /**
     * Sleep test execution for a given amount of time
     * @param timeout Timeout in milliseconds
     */
    public static void sleep(int timeout){
        try{
            Thread.sleep(timeout);
        }
        catch (Exception ex){
            logger.error("Error trying to sleep: '" + ex.getMessage() + "'");
        }
    }

    /**
     * Wait for JQuery Ajax calls to complete
     * @param timeout Timeout in milliseconds
     */
    public static void waitForAjax(int timeout) {
        int timeoutInSeconds = timeout;

        logger.info("Checking active ajax calls by calling jquery.active");
        try {
            if (driver() instanceof JavascriptExecutor) {
                JavascriptExecutor jsDriver = (JavascriptExecutor) driver();

                for (int i = 0; i < timeoutInSeconds; i++) {
                    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
                    // return should be a number
                    if (numberOfAjaxConnections instanceof Long) {
                        Long n = (Long) numberOfAjaxConnections;
                        logger.info("Number of active jquery ajax calls: " + n);
                        if (n.longValue() == 0L) {
                            break;
                        }
                    }
                    Thread.sleep(200);
                }
            } else {
                logger.info("Web driver: " + driver() + " cannot execute javascript");
            }
        } catch (InterruptedException e) {
            logger.error("InterruptedException ", e);
            //throw new TestAutomationException("InterruptedException ", e);
        }
    }

    /**
     * Wait for JQuery Ajax calls to complete
     */
    public static void waitForAjax(){
        waitForAjax(60);
        //TODO Get the default timeout from property file.
    }

    /**
     * Wait for an element to be Displayed
     * @param element WebElement
     * @param timeoutInSeconds Timeout in milliseconds
     */
    public  static void waitToBeDisplayed(WebElement element, int timeoutInSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver(), timeoutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeoutInSeconds + "ms, failed to display element ";
            logger.error(errorMessage);
        }
        catch (Exception ex){
            logger.error("Error in waitToBeDisplayed: " + ex.getMessage());
        }
    }

    /**
     * Wait for an element to be Displayed
     * @param element WebElement
     */
    public  static void waitToBeDisplayed(WebElement element){
        waitToBeDisplayed(element, 60);
        //TODO Get the default timeout from property file.
    }

    /**
     * Wait for an element to be Clickable
     * @param element WebElement
     * @param timeOutInSeconds Timeout in milliseconds
     */
    public static void waitToBeClickable(WebElement element, int timeOutInSeconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeOutInSeconds + "ms, element failed to be clickable";
            logger.error(errorMessage);
        }
        catch (Exception ex){
            logger.error("Error in waitToBeClickable: " + ex.getMessage());
        }
    }

    /**
     * Wait for an element to be Clickable
     * @param element WebElement
     */
    public static void waitToBeClickable(WebElement element){
       waitToBeClickable(element, 60);
        //TODO Get the default timeout from property file.
    }

    /**
     * Wait for an element to be Hidden/ Not Visible
     * @param element WebElement
     * @param timeOutInSeconds Timeout in milliseconds
     */
    @SuppressWarnings("null")
	public static void waitToBeHidden(WebElement element, int timeOutInSeconds){
        //TODO "We might need to set the Implicit wait to 0 here - verify later" ;
        List<WebElement> elements = null;
        try {
            // First add the element to a list because ExpectedConditions.invisibilityOfAllElements only accepts a list
            elements.add(element);
            WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
            wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeOutInSeconds + "ms, element is not hidden";
            logger.error(errorMessage);
            throw timeoutex;
        }
        catch (Exception ex){
            logger.error("Error in waitToBeHidden: " + ex.getMessage());
        }
    }

    /**
     * Wait for an element to be Hidden/ Not Visible
     * @param element WebElement
     */
    public static void waitToBeHidden(WebElement element){
        waitToBeHidden(element, 60);
        //TODO Get the default timeout from property file.
    }

    /**
     * Wait for an element to contain any text
     * Checks the element.getText().length() != 0
     * @param element WebElement
     * @param timeOutInSeconds Timeout in milliseconds
     */
    public static void waitForAnyText(final WebElement element, int timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return element.getText().length() != 0;
                }
            });
        }
        catch (TimeoutException timeoutex){
            String errorMessage = "After " + timeOutInSeconds + "ms, element failed to contain any text";
            logger.error(errorMessage);
            throw timeoutex;
        }
        catch (Exception ex){
            logger.error("Error in waitForAnyText: " + ex.getMessage());
        }
    }

    /**
     * Wait for an element to contain given text
     * @param element WebElement
     * @param text Text to contain
     * @param timeOutInSeconds Timeout in milliseconds
     */
    public static void waitForContainText(final WebElement element, String text, long timeOutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        }
        catch (TimeoutException timeoutex) {
            String errorMessage = "After " + timeOutInSeconds + "ms, element failed to contain given text: " + text;
            logger.error(errorMessage);
            throw timeoutex;
        }
        catch (Exception ex){
            logger.error("Error in waitForContainText: " + ex.getMessage());
        }
    }
    
}
