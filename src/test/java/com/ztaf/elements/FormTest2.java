package com.ztaf.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ztaf.driver.DriverManager;
import com.ztaf.elements.base.Element;
import com.ztaf.elements.helpers.FormTestObject;
import com.ztaf.elements.widget.Label;

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

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
