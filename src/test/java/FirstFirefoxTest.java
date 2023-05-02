import driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstFirefoxTest {

    WebDriver driver;

    @Test
    public void firstTest() {
        // Створення драйверу
        driver = new Driver().initDriver("firefox");

        driver.get("http://the-internet.herokuapp.com/login");

        Assert.assertEquals(driver.getTitle(), "The Internet");

        driver.quit();
    }
}