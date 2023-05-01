import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstFirefoxTest {

    @Test
    public void firstTest() {
        // Створення драйверу
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("/usr/bin/firefox");

        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("http://the-internet.herokuapp.com/login");

        Assert.assertEquals(driver.getTitle(), "The Internet");

        driver.quit();
    }
}