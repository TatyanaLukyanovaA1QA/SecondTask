package google.framework.elements;

import google.framework.browser.Browser;
import google.framework.utils.LogUtil;
import google.framework.utils.WaiterUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected String locator;
    protected String name;

    protected BaseElement(String locator, String name) {
        LogUtil.info(String.format("Data initialization for element - \"%s\".", name));
        this.locator = locator;
        this.name = name;
    }

    protected WebElement findElement(){
        LogUtil.info(String.format("Searching of element - \"%s\".", name));
        WaiterUtil.explicitWaitOfVisibility(locator);
        return Browser.getDriver().findElement(By.xpath(locator));
    }

    public boolean isElementVisible() {
        LogUtil.info(String.format("Checking visibility of element \"%s\".", name));
        try {
            WaiterUtil.explicitWaitOfVisibility(locator);
            return true;
        } catch (Exception e) {
            LogUtil.info(String.format("Element with locator :%s is not visible.", locator));
        }
        return false;
    }
}
