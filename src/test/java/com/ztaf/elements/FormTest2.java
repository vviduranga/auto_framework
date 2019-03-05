package com.ztaf.elements;

import static com.fortaf.framework.core.WaitHandler.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fortaf.drivers.DriverManager;
import com.ztaf.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */

public class FormTest2 {
    static WebDriver driver;
    static FormTestObject testObject;

    @BeforeClass
    public static void beforeClass() {
        driver = new DriverManager().getBrowser("chrome");
        testObject = FormTestObject.initialize(driver);
        testObject.get();
    }

    @Test
    public void selectWiredProperly() {
        testObject.selectFragment.getOption1().selectByIndex(0);
        Assert.assertEquals(1, testObject.selectFragment.getOption1().getAllSelectedOptions().size());
        Assert.assertNotNull(testObject.selectFragment.getSubElement(By.id("option1")));
    }

    @Test
    public void testWait() {
    	sleep(10);
    }
    
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
