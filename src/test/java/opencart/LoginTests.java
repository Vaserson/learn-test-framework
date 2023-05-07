package opencart;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.web.opencart.HomePage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void successLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("user@localhost.com");
        driver.findElement(By.id("input-password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.linkText("Edit your account information")).click();

        Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), "user@localhost.com");
    }

    @Test
    public void successLoginPOM() {
        HomePage homePage = new HomePage(driver);

        homePage.goTo("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
        homePage.clickMyAccountDropDown();
        homePage.clickBtnLogin();
        homePage.fillEmail("user@localhost.com");
        homePage.fillPassword("password");
        homePage.clickBtnLoginSubmit();
        homePage.clickLinkAccountInfo();

        Assert.assertEquals(homePage.getEmailFldValue(), "user@localhost.com");
    }
}
