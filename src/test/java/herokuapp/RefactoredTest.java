package herokuapp;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RefactoredTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @Test
    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }

    @Test
    public void firstTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "You logged into a secure area!");
    }

    @Test
    public void filedLoginWithInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("WRONG_PASSWORD!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your password is invalid!");
    }

    @Test
    public void filedLoginWithInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("WRONG_LOGIN");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("flash")).getText().split("\n")[0], "Your username is invalid!");
    }
}