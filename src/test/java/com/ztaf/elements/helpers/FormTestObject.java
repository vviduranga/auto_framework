package com.ztaf.elements.helpers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.basic.CheckBox;
import com.fortaf.elements.basic.Label;
import com.fortaf.elements.basic.Select;
import com.fortaf.elements.basic.Table;
import com.fortaf.elements.basic.TextInput;
import com.fortaf.elements.custom.SelectFragment;
import com.fortaf.framework.core.BasePage;

import static com.fortaf.drivers.DriverManager.driver;

/**
 * declare elements of a form.
 */
public class FormTestObject extends BasePage{

    private WebDriver driver;

    public TextInput texta;

    //@FindBy(id = "test1")
    public Element test1;

    @FindBy(id = "test1")
    public WebElement webElement;
    
    public Select option1;

    @FindBy(id = SelectFragment.ID_LOCATOR)
    public SelectFragment selectFragment;

    //@FindBy(id = "checkbox")
    public CheckBox checkbox;
    
    //@FindBy(id = "table")
    public Table table;

    @FindBy(tagName = "label")
    public List<Label> labels;

    @FindBy(tagName = "label")
    public List<Element> elementLabels;

    @FindBy(tagName = "label")
    public List<WebElement> webElementLabels;

    @FindBy(css = "label[for='textb']")
    public WebElement labelForTextB;

    public FormTestObject() {
        super();
        this.driver = driver();
    }
    
//    public FormTestObject(WebDriver driver) {
//        this.driver = driver;
//    }

//    /**
//     * Static factory for generating the class.
//     *
//     * @param driver The WebDriver for the session.
//     * @return FormTestObject.
//     */
//    public static FormTestObject initialize(WebDriver driver) {
//        return ElementFactory.initElements(driver, FormTestObject.class);
//    }

    public void get() {
        PageLoader.get(driver, "forms.html");
    }

    public void close() {
        driver.close();
    }

}
