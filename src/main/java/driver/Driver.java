package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private WebDriver driver;

    public WebDriver initDriver(String browser) {
        switch (browser) {
            case "chrome" -> driver = WebDriverManager.chromedriver().create();

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("/usr/bin/firefox");

                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();

        return driver;
    }
}