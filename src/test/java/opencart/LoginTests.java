package opencart;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.web.opencart.HomePage;


public class LoginTests extends BaseTest {

    @BeforeMethod
    public void goToHomePage() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
    }

    @Test
    public void successLogin() {
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("user@localhost.com");
        driver.findElement(By.id("input-password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.linkText("Edit your account information")).click();

        Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), "user@localhost.com");
    }

    @Test
    public void successLoginExplicitWait() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys("user@localhost.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys("password");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Login']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Edit your account information"))).click();

        String emailFieldValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).getAttribute("value");
        Assert.assertEquals(emailFieldValue, "user@localhost.com");
    }

    @Test
    public void successLoginPOM() {
        HomePage homePage = new HomePage(driver);

        homePage.clickMyAccountDropDown();
        homePage.clickBtnLogin();
        homePage.fillEmail("user@localhost.com");
        homePage.fillPassword("password");
        homePage.clickBtnLoginSubmit();
        homePage.clickLinkAccountInfo();

        Assert.assertEquals(homePage.getEmailFldValue(), "user@localhost.com");
    }
}
