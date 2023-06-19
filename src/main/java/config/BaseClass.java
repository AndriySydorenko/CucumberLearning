package config;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
static public WebDriver driver;
    @BeforeClass
    public static void BeforParent() {
        driver = ConfigurationWebDriver.createDriver(WebDrivers.CHROME_INCOGNITO);

    }

    @AfterClass
    public static void afterParent() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}
