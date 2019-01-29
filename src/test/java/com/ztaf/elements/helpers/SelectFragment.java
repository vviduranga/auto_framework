/**
 * 
 */
package com.ztaf.elements.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.ztaf.elements.base.Element;
import com.ztaf.elements.base.ImplementedBy;
import com.ztaf.elements.widget.Select;

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
