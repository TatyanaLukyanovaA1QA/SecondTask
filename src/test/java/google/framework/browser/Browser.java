package google.framework.browser;

import google.framework.utils.LogUtil;
import google.framework.utils.WaiterUtil;
import org.openqa.selenium.WebDriver;

import static google.framework.browser.DriverFactory.setDriverNull;

public final class Browser {

    private Browser() {}

    public static WebDriver getDriver() {
        return DriverFactory.getInstance();
    }

    public static void switchFromIFrameToDefaultPage() {
        LogUtil.info("Transition from frame to page.");
        getDriver().switchTo().defaultContent();
    }

    public static void switchToFrame(String frameName) {
        LogUtil.info(String.format("Transition to frame \"%s\".", frameName));
        getDriver().switchTo().frame(frameName);
    }

    public static void moveTo(String url) {
        LogUtil.info(String.format("Opening a web page \"%s\".", url));
        getDriver().get(url);
    }

    public static void maximizeWindow() {
        LogUtil.info("Enlarging the browser window.");
        getDriver().manage().window().maximize();
    }

    public static boolean isAlertPresent() {
        LogUtil.info("Checking presence of alert.");
        try {
            WaiterUtil.explicitWaitOfPresenceOfAlert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isAlertNotPresent() {
        LogUtil.info("Сhecking for no alert.");
        try {
            WaiterUtil.fluentWaitClosureOfAlert();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static String getAlertText() {
        LogUtil.info("Getting alert text.");
        return getDriver().switchTo().alert().getText();
    }

    public static void acceptAlert() {
        LogUtil.info("Alert pressing the \"OK\" button.");
        try {
            WaiterUtil.explicitWaitOfPresenceOfAlert();
            getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            LogUtil.error("Alert does not exist.");
        }
    }

    public static void sendKeysToAlert(String text){
        LogUtil.info("Sending text to alert.");
        try {
            WaiterUtil.explicitWaitOfPresenceOfAlert();
            getDriver().switchTo().alert().sendKeys(text);
        } catch (Exception e) {
            LogUtil.error("No alert for text transmission.");
        }
    }

    public static void quit() {
        LogUtil.info("Closing a web page.");
        getDriver().quit();
        setDriverNull();
    }
}
