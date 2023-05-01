import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstChromeTest {
    WebDriver driver;

    @Test
    public void firstTest() {
        // Створення драйверу
        driver = WebDriverManager.chromedriver().create();
        // Далі пішла робота з драйвером
        driver.get("http://the-internet.herokuapp.com/login");

        // Перевірка заголовку сайту
        Assert.assertEquals(driver.getTitle(), "The Internet");

        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "You logged into a secure area!");

        // Закриття драйверу
        driver.quit();
    }

    @Test
    public void filedLoginWithInvalidPassword() {
        // Створення драйверу
        driver = WebDriverManager.chromedriver().create();
        // Далі пішла робота з драйвером
        driver.get("http://the-internet.herokuapp.com/login");

        // Перевірка заголовку сайту
        Assert.assertEquals(driver.getTitle(), "The Internet");

        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("WRONG_PASSWORD!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your password is invalid!");

        // Закриття драйверу
        driver.quit();
    }

    @Test
    public void filedLoginWithInvalidLogin() {
        // Створення драйверу
        driver = WebDriverManager.chromedriver().create();
        // Далі пішла робота з драйвером
        driver.get("http://the-internet.herokuapp.com/login");

        // Перевірка заголовку сайту
        Assert.assertEquals(driver.getTitle(), "The Internet");

        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("WRONG_LOGIN");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your username is invalid!");

        // Закриття драйверу
        driver.quit();
    }
}
