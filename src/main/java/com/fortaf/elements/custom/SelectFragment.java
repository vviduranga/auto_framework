package com.fortaf.elements.custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fortaf.elements.base.Element;
import com.fortaf.elements.base.ImplementedBy;
import com.fortaf.elements.basic.Select;

/**
 * Fragment of options just for demonstration purpose.
 * @author 
 *
 */
@ImplementedBy(SelectFragmentImpl.class)
public interface SelectFragment extends Element {
    
    final String ID_LOCATOR = "options";
    
    Select getOption1();
    
    WebElement getSubElement(By by);

}
