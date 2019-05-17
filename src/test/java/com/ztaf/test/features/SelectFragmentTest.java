package com.ztaf.test.features;

import static com.fortaf.framework.core.WaitHandler.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fortaf.framework.drivers.DriverManager;
import com.ztaf.elements.helpers.FormTestObject;

/**
 * Test the form element types.
 */

public class SelectFragmentTest {
    static WebDriver driver;
    static FormTestObject testObject;

    @BeforeClass
    public static void beforeClass() {
        driver = new DriverManager().getBrowser("chrome");

    }

    @Test
    public void selectWiredProperly() {
        testObject = new FormTestObject();
        testObject.get();
        
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
