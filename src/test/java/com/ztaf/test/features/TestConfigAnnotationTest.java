package com.ztaf.test.features;

import static com.fortaf.framework.drivers.DriverManager.driver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.fortaf.framework.annotations.WebTest;
import com.fortaf.framework.common.Browser;
import com.ztaf.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */
@WebTest(browser=Browser.chrome, baseUrl = "http://www.google.com")
public class TestConfigAnnotationTest {

	static FormTestObject testObject;

	@Test
    public void googleSearch() throws InterruptedException {
        driver().findElement(By.name("q")).sendKeys("abc");
        Thread.sleep(1000);
        
    }

}
