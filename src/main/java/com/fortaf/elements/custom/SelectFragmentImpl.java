package com.fortaf.elements.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fortaf.elements.base.ElementImpl;
import com.fortaf.elements.basic.Select;
import com.fortaf.elements.factory.api.ElementFactory;

/**
 * Implementation of {@link SelectFragment}.
 * @author
 *
 */
public class SelectFragmentImpl extends ElementImpl implements SelectFragment {

    
    @FindBy(id = "option1")
    private Select option1;
    
    public SelectFragmentImpl(WebElement element) {
        super(element);
        ElementFactory.initElements(element, this);   
    }

    @Override
    public Select getOption1() {
        return option1;
    }

    @Override
    public WebElement getSubElement(By by) {
        return findElement(by);
    }
    
    

}
