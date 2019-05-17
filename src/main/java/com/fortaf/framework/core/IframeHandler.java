package com.fortaf.framework.core;

import static com.fortaf.framework.drivers.DriverManager.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class IframeHandler {

    private static final Logger logger = Logger.getLogger(IframeHandler.class);


    /**
     * Switch to iframe by given index
     * @param index iframe index
     */
    public static void SwitchToIframeByIndex(int index) {
        try {
            driver().switchTo().frame(index);
        } catch (Exception e) {
            logger.error("Unable to switch Iframe " + e.getMessage());
        }
    }

    /**
     * Switch to iframe by given iframe WebElement
     * @param element iframe WebElement
     */
    public static void SwitchToIframeWebElement(WebElement element) {
        try {
        	driver().switchTo().frame(element);
        } catch (Exception e) {
            logger.error("Unable to switch Iframe " + e.getMessage());
        }
    }

    /**
     * Switch to iframe by given iframe name
     * @param name iframe name
     */
    public static void SwitchToIframeByName(String  name) {
        try {
        	driver().switchTo().frame(name);
        } catch (Exception e) {
            logger.error("Unable to switch Iframe " + e.getMessage());
        }
    }

    /**
     * Switch to iframe by given iframe element id
     * @param Id iframe element id
     */
    public static void SwitchToIframeById(String  Id) {
        try {
        	driver().switchTo().frame(Id);
        } catch (Exception e) {
            logger.error("Unable to switch Iframe " + e.getMessage());
        }
    }

    /**
     * Switch to the first iframe in the page
     */
    public static void SwitchToIframe() {
        try {
        	driver().switchTo().defaultContent();
        	driver().switchTo().frame(0);
        } catch (Exception e) {
            logger.error("Unable to find any iframes " + e.getMessage());
        }
    }

    /**
     * Switch out of any iframe and Switch back to main page
     */
    public static void SwitchToDeafultContent() {
        try {
        	driver().switchTo().defaultContent();
        } catch (Exception e) {
            logger.error("Unable to find default content " + e.getMessage());
        }
    }
    
}
