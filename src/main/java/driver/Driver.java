package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver {

    private WebDriver driver;

    public WebDriver initDriver() {
        driver = WebDriverManager.chromedriver().create();

        return driver;
    }
}