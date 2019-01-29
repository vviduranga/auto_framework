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

public class FormTest {
    static WebDriver driver;
    static FormTestObject testObject;

    @BeforeClass
    public static void beforeClass() {
    	
    	//System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("disable-extensions");
        //options.addArguments("--start-maximized");
        //driver = new ChromeDriver(options);
        driver = new DriverManager().getBrowser("chrome");
        testObject = FormTestObject.initialize(driver);
        testObject.get();
    }
    
/*    @BeforeTest
    public void beforeTest() {
    	testObject.get();
    }*/

/*    @Test
    public void isChecked() {
        Assert.assertFalse(testObject.checkbox.isChecked());
    }*/

    @Test
    public void check() {
        testObject.checkbox.check();
        Assert.assertTrue(testObject.checkbox.isChecked());
    }

    @Test
    public void uncheck() {
        testObject.checkbox.click();
        testObject.checkbox.uncheck();
        Assert.assertFalse(testObject.checkbox.isChecked());
    }

    @Test
    public void selectWiredProperly() {
        testObject.selectFragment.getOption1().selectByIndex(0);
        Assert.assertEquals(1, testObject.selectFragment.getOption1().getAllSelectedOptions().size());
        Assert.assertNotNull(testObject.selectFragment.getSubElement(By.id("option1")));
    }

    @Test
    public void getLabelsList() {
        for (Label label : testObject.labels) {
            Assert.assertNotNull(label.getFor());
        }
    }

    @Test
    public void getElementLabelsList() {
        for (Element webElementLabel : testObject.elementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElementLabelsList() {
        for (WebElement webElementLabel : testObject.webElementLabels) {
            Assert.assertNotNull(webElementLabel.getAttribute("for"));
        }
    }

    @Test
    public void getWebElement() {
        Assert.assertTrue(testObject.labelForTextB.isDisplayed());
    }

    @Test
    public void formElement() {
        Assert.assertTrue(testObject.test1.elementWired());
    }

    @Test
    public void textInputSet() {
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputClear() {
        testObject.texta.set("TestText");
        testObject.texta.clear();
        Assert.assertEquals("", testObject.texta.getAttribute("value"));
    }

    @Test
    public void textInputGetValue() {
        testObject.texta.set("TestText");
        Assert.assertEquals("TestText", testObject.texta.getText());
    }

    @Test
    public void formWebElement() {
        Assert.assertTrue(testObject.webElement.isDisplayed());
    }
    
    @Test
    public void tableRowCount() {
    	Assert.assertEquals(4, testObject.table.getRowCount());
    }
    
    @Test
    public void tableColumnCount() {
    	Assert.assertEquals(2, testObject.table.getColumnCount());
    }
    
    @Test
    public void tableGetHeaderCell() {
    	Assert.assertEquals("Month", testObject.table.getCellAtIndex(0, 0).getText());
    }
    
    @Test
    public void tableGetBodyCell() {
    	Assert.assertEquals("$80", testObject.table.getCellAtIndex(2, 1).getText());
    }
    
    @Test
    public void tableGetFooterCell() {
    	Assert.assertEquals("Sum", testObject.table.getCellAtIndex(3, 0).getText());
    }
    
    @Test(expectedExceptions=InvalidElementStateException.class)
    public void selectDisabledElement() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        final String disabledOptionText = "Disabled option";
        testObject.option1.selectByVisibleText(disabledOptionText);
    }
    
    @Test(expectedExceptions=InvalidElementStateException.class)
    public void selectDisabledElementByValue() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByValue("option3");
    }

    
    @Test(expectedExceptions=InvalidElementStateException.class)
    public void selectDisabledElementByIndex() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByIndex(2);
    }

       
    @Test(expectedExceptions=NoSuchElementException.class)
    public void selectNonExistingElementSelectByIndex() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByIndex(10);
    }

    @Test(expectedExceptions=NoSuchElementException.class)
    public void selectNonExistingElementSelectByValue() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByValue("foofoo");
    }

    @Test(expectedExceptions=NoSuchElementException.class)
    public void selectNonExistingElementSelectByVisibleText() {
        Assert.assertEquals("option1", testObject.option1.getFirstSelectedOption().getText());
        testObject.option1.selectByVisibleText("fooBar");
    }

    
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
