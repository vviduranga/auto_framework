package com.fortaf.framework.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSActions {

    private static final Logger logger = Logger.getLogger(JSActions.class);
    
    /**
     * Clicks on an element using Javascript
     * @param element WebElement to click on
     */
    public static void clickByJS(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) WebActions.driver;
            executor.executeScript("arguments[0].click();", element);
            logger.debug("Clicked on element: '" + element.toString() + "'");
        } catch (Exception e) {
            logger.error("Clicking on element failed " + e.getMessage());
        }
    }

    /**
     * SendKeys to an element(textbox) using Javascript
     * @param element WebElement to SendKeys
     */
    public static void sendKeysByJS(WebElement element, String text) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) WebActions.driver;
            executor.executeScript("arguments[0].setAttribute('value', '" + text +"')", element);
            logger.debug("SendKeys by Javascript on element: '" + element.toString() + "'");
        } catch (Exception e) {
            logger.error("SendKeys by Javascript on element failed " + e.getMessage());
        }
    }
    
    /**
     * Clear an element(textbox) using Javascript
     * @param element WebElement to Clear
     */
    public static void clearByJS(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) WebActions.driver;
            executor.executeScript("arguments[0].setAttribute('value', '')", element);
            logger.debug("SendKeys by Javascript on element: '" + element.toString() + "'");
        } catch (Exception e) {
            logger.error("SendKeys by Javascript on element failed " + e.getMessage());
        }
    }
}
