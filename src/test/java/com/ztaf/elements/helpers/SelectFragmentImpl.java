/**
 * 
 */
package com.ztaf.elements.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ztaf.elements.base.ElementImpl;
import com.ztaf.elements.factory.api.ElementFactory;
import com.ztaf.elements.widget.Select;

/**
 * Implementation of {@link SelectFragment}.
 * @author niels
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
