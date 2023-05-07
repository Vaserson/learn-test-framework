package base;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser;
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = "chrome";
        }
        driver = new Driver().initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
