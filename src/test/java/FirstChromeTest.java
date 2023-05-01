import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstChromeTest {

    @Test
    public void firstTest() {
        // Встановлення системної змінної зі шляхом до chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        // Створення драйверу
        WebDriver driver = new ChromeDriver();

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
        // Встановлення системної змінної зі шляхом до chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        // Створення драйверу
        WebDriver driver = new ChromeDriver();

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
        // Встановлення системної змінної зі шляхом до chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

        // Створення драйверу
        WebDriver driver = new ChromeDriver();

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