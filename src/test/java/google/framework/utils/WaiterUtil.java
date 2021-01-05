package google.framework.utils;

import google.framework.browser.Browser;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaiterUtil {
    private final static int FIVE_HUNDRED_MICROSEC = Integer.parseInt(PropertyReader.
            getWaiterConstant("FIVE_HUNDRED_MICROSEC"));
    private final static int TWO_SEC = Integer.parseInt(PropertyReader.getWaiterConstant("TWO_SEC"));
    private final static int FIVE_SEC = Integer.parseInt(PropertyReader.getWaiterConstant("FIVE_SEC"));
    private final static int TEN_SEC = Integer.parseInt(PropertyReader.getWaiterConstant("TEN_SEC"));


    public static void explicitWaitOfVisibility(String locator) {
        WebDriverWait waiter = new WebDriverWait(Browser.getDriver(), 20);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void explicitWaitOfPresenceOfAlert(){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), TWO_SEC);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void fluentWaitClosureOfAlert() {
        Wait wait = new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(TEN_SEC))
                .pollingEvery(Duration.ofMillis(FIVE_HUNDRED_MICROSEC))
                .ignoring(NoAlertPresentException.class);
        wait.until((WebDriver) -> Browser.getDriver().switchTo().alert());
    }

    public static void fluentWaitVisibilityOfElement(String locator) {
        Wait wait = new FluentWait<>(Browser.getDriver())
                .withTimeout(Duration.ofSeconds(TEN_SEC))
                .pollingEvery(Duration.ofMillis(FIVE_HUNDRED_MICROSEC))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void explicitWaitOfPresence(String locator) {
        WebDriverWait waiter = new WebDriverWait(Browser.getDriver(), TEN_SEC);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void explicitWaitOfClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), FIVE_SEC);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
