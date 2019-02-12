package com.ztaf.elements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fortaf.annotations.TestConfig;
import com.fortaf.annotations.TestConfig.Browser;
import com.fortaf.drivers.DriverManager;
import com.fortaf.annotations.TestNGAnnotationHandler;
import com.fortaf.elements.base.Element;
import com.fortaf.elements.basic.Label;
import com.ztaf.elements.helpers.FormTestObject;
/**
 * Test the form element types.
 */

@TestConfig(browser=Browser.chrome)
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
    
    @Test
	public void loginTest() throws IOException
	{    
            // Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
            // I used (.) in path where represent the current working directory
	    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/learn_automation1.html");
		
            // Create object of ExtentReports class- This is main class which will create report
	    ExtentReports extent = new ExtentReports();
	    
            // attach the reporter which we created in Step 1
	    extent.attachReporter(reporter);
	    
            // call createTest method and pass the name of TestCase- Based on your requirement
	    ExtentTest logger=extent.createTest("LoginTest");
	    
            // log method will add logs in report and provide the log steps which will come in report
	    logger.log(Status.INFO, "Login to amazon");
	   
	    logger.log(Status.PASS, "Title verified");
	   
            // Flush method will write the test in report- This is mandatory step  
	    extent.flush();
		
            // You can call createTest method multiple times depends on your requirement
            // In our case we are calling twice which will add 2 testcases in our report
	    ExtentTest logger2=extent.createTest("Logoff Test");
	    
	    logger2.log(Status.FAIL, "Title verified");
	    
	    logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
        
	    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath("/Users/mukeshotwani/Desktop/logo.jpg").build());
 
            // This will add another test in report
	    extent.flush();
	    	
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
            Assert.assertNotNull(label.getValue());
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
