package com.fortaf.framework.core;

import static com.fortaf.drivers.DriverManager.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fortaf.test.config.Timeout;

public class AlertHandler {

	private static final Logger logger = Logger.getLogger(AlertHandler.class);

	private static long defaultTimeout = Timeout.ALERT_TIMEOUT.getSeconds();

	/**
	 * Accept Alert if present. This will wait for a default timeout of 30
	 * seconds if alert is not visible immediately
	 */
	public static void AcceptAlertIfPresent() {
		AcceptAlertIfPresent(defaultTimeout);
	}

	/**
	 * Accept Alert if present.
	 * 
	 * @param timeOutInSeconds
	 *            timeout to wait until an alert is present (in Seconds)
	 */
	public static void AcceptAlertIfPresent(long timeOutInSeconds) {
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
		try {
			wait.ignoring(NoAlertPresentException.class);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver().switchTo().alert();
			alert.accept();
			found = true;
		} catch (TimeoutException e) {
			logger.debug("Alert not present after timeout of:" + timeOutInSeconds + "" + e.getMessage());
			// Swallow the exception. As this method will be used only to accept
			// an alert if exists
		} catch (Exception e) {
			logger.debug("Unexpected error waiting for alert:" + e.getMessage());
		}
		if (!found) {
			logger.info("Alert Not found");
			return;
		}
	}

	/**
	 * Dismiss Alert if present. This will wait for a default timeout of 30
	 * seconds if alert is not visible immediately
	 */
	public static void DismissAlertIfPresent() {
		DismissAlertIfPresent(defaultTimeout);
	}

	/**
	 * Dismiss Alert if present.
	 * 
	 * @param timeOutInSeconds
	 *            timeout to wait until an alert is present (in Seconds)
	 */
	public static void DismissAlertIfPresent(long timeOutInSeconds) {
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
		try {
			wait.ignoring(NoAlertPresentException.class);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver().switchTo().alert();
			alert.accept();
			found = true;
		} catch (TimeoutException e) {
			logger.debug("Alert not present after timeout of:" + timeOutInSeconds + "" + e.getMessage());
			// Swallow the exception. As this method will be used only to
			// dismiss an alert if exists
		} catch (Exception e) {
			logger.debug("Unexpected error waiting for alert:" + e.getMessage());
		}
		if (!found) {
			logger.info("Alert Not found");
			return;
		}
	}

	/**
	 * Accept Alert if present and get the alert text This will wait for a
	 * default timeout of 30 seconds if alert is not visible immediately
	 * 
	 * @return Text in the alert
	 */
	public static String AcceptAlertIfPresentAndGetMessage() {
		return AcceptAlertIfPresentAndGetMessage(defaultTimeout);
	}

	/**
	 * Accept Alert if present and get the alert text
	 * 
	 * @param timeOutInSeconds
	 *            timeout to wait until an alert is present (in Seconds)
	 * @return Text in the alert
	 */
	public static String AcceptAlertIfPresentAndGetMessage(long timeOutInSeconds) {
		String text = "";
		WebDriverWait wait = new WebDriverWait(driver(), timeOutInSeconds);
		try {
			wait.ignoring(NoAlertPresentException.class);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver().switchTo().alert();
			text = alert.getText();
			alert.accept();
		} catch (TimeoutException e) {
			logger.debug("Alert not present after timeout of:" + timeOutInSeconds + "" + e.getMessage());
			// Swallow the exception. As this method will be used only to accept
			// an alert if exists
		} catch (Exception e) {
			logger.debug("Unexpected error waiting for alert:" + e.getMessage());
		}
		return text;
	}

	/**
	 * Tries to get the alert message without waiting
	 * 
	 * @return Text in the alert
	 * @throws Exception
	 */
	public static String GetAlertMessage() throws Exception {
		String text = "";
		try {
			Alert alert = driver().switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			logger.debug("Alert not present" + e.getMessage());
			text = "No Alert Found!";
		} catch (Exception e) {
			throw new Exception("Unexpected error while trying to get alert text", e);
		}
		return text;
	}

	/**
	 * Checks whether an alert is present NOTE: This function does not wait
	 * 
	 * @return true if alert found
	 */
	public static boolean IsPresent() {
		boolean found = false;
		try {
			Alert alert = driver().switchTo().alert();
			if (alert != null) {
				found = true;
			}
		} catch (NoAlertPresentException nae) {
			// Swallow this since we are relying on 'found' flag
		} catch (Exception e) {
			// Swallow this since we are relying on 'found' flag
		}
		return found;
	}
}
