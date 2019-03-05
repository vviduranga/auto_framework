package com.fortaf.framework.core;

import static com.fortaf.drivers.DriverManager.driver;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHandler {

	private static final Logger logger = Logger.getLogger(WindowHandler.class);

	/**
	 * Switch to browser window by title
	 * 
	 * @param windowTitle
	 * @return
	 */
	public static WebDriver SwitchToWindowByTtitle(String windowTitle) {
		WebDriver newWindow = null;
		try {
			Set<String> handles = driver().getWindowHandles();
			Iterator<String> ite = handles.iterator();
			while (ite.hasNext()) {
				String tempWindow = ite.next().toString();
				newWindow = driver().switchTo().window(tempWindow);
				if (newWindow.getTitle() == windowTitle)
					break;
			}
		} catch (Exception e) {
			logger.error("Unable to switch window " + e.getMessage());
		}
		return newWindow;
	}

	/**
	 * Switch to browser window by URL
	 * 
	 * @param windowURL
	 * @return
	 */
	public static WebDriver SwitchToWindowByURL(String windowURL) {

		WebDriver newWindow = null;
		try {
			Set<String> handles = driver().getWindowHandles();
			Iterator<String> ite = handles.iterator();
			while (ite.hasNext()) {
				String tempWindow = ite.next().toString();
				newWindow = driver().switchTo().window(tempWindow);
				if (newWindow.getCurrentUrl() == windowURL)
					break;
			}
		} catch (Exception e) {
			logger.error("Unable to switch window " + e.getMessage());
		}
		return newWindow;
	}

	/**
	 * Switch to browser window by Partial URL
	 * 
	 * @param windowURL
	 * @return
	 */
	public static WebDriver SwitchToWindowByPartialURL(String windowPartialURL) {

		WebDriver newWindow = null;
		try {
			Set<String> handles = driver().getWindowHandles();
			Iterator<String> ite = handles.iterator();
			while (ite.hasNext()) {
				String tempWindow = ite.next().toString();
				newWindow = driver().switchTo().window(tempWindow);
				if (newWindow.getTitle().contains(windowPartialURL))
					break;
			}

		} catch (Exception e) {
			logger.error("Unable to switch window " + e.getMessage());
		}
		return newWindow;

	}

}
