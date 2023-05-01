import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstChromeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Створення драйверу
        driver = WebDriverManager.chromedriver().create();
        // Далі пішла робота з драйвером
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void tearDown() {
        // Закриття драйверу
        driver.quit();
    }

    @Test
    public void titleTest() {
        // Перевірка заголовку сайту
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }

    @Test
    public void firstTest() {
        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "You logged into a secure area!");
    }

    @Test
    public void filedLoginWithInvalidPassword() {
        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("WRONG_PASSWORD!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your password is invalid!");
    }

    @Test
    public void filedLoginWithInvalidLogin() {
        // Пошук елементів і взяємодія з ними
        driver.findElement(By.id("username")).sendKeys("WRONG_LOGIN");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Перевірка повідомлення після успішного логіну
        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your username is invalid!");
    }
}