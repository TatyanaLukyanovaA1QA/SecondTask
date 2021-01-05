package google.framework.browser;


import google.framework.utils.LogUtil;
import google.framework.utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getInstance() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static WebDriver initDriver() {
        String browser = PropertyReader.getConfigValue("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(capabilities);
                break;
            default:
                LogUtil.error("Invalid browser");
                break;
        }
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}
