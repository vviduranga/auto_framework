package com.ztaf.elements;

import static com.fortaf.drivers.DriverManager.driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.fortaf.annotations.TestConfig;
import com.fortaf.annotations.TestConfig.Browser;
import com.ztaf.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */
@TestConfig(browser=Browser.chrome, baseUrl = "http://www.google.com")
public class FormTest {

	static FormTestObject testObject;

	@Test
    public void isChecked() throws InterruptedException {
        driver().findElement(By.name("q")).sendKeys("abc");
        Thread.sleep(100);

    }

}
