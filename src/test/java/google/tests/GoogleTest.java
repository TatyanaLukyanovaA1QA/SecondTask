package google.tests;

import google.app.pages.MainPage;
import google.framework.browser.Browser;
import google.framework.utils.LogUtil;
import google.framework.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
    @BeforeTest
    public void setUp(){
        Browser.getDriver();
        Browser.moveTo(PropertyReader.getConfigValue("URL"));
    }

    @Test
    public void test(){
        LogUtil.step(1, "Go to the resource.");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Page does not open.");
        LogUtil.info("Test passed successfully.");
    }

    @AfterTest
    public void tearDown(){
        Browser.quit();
    }
}