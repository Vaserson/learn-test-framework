package opencart;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.web.opencart.bad.HomePageBadApproach;
import pages.web.opencart.bpmethods.AccountInfoPageBPMethods;
import pages.web.opencart.bpmethods.HomePageBPMethods;
import pages.web.opencart.explicit.AccountInfoPageExplicit;
import pages.web.opencart.explicit.HomePageExplicit;
import pages.web.opencart.nochaining.AccountInfoPageNoChaining;
import pages.web.opencart.nochaining.AccountPageNoChaining;
import pages.web.opencart.nochaining.HomePageNoChaining;
import pages.web.opencart.nochaining.LoginPageNoChaining;
import pages.web.opencart.pagefactory.AccountInfoPageFactory;
import pages.web.opencart.pagefactory.HomePageFactory;
import pages.web.opencart.standard.AccountInfoPageStandard;
import pages.web.opencart.standard.AccountPageStandard;
import pages.web.opencart.standard.HomePageStandard;
import pages.web.opencart.standard.LoginPageStandard;


public class LoginTests extends BaseTest {

    @BeforeMethod
    public void goToHomePage() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
    }

    @Test
    public void successLoginNoPOM() {
        driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("user@localhost.com");
        driver.findElement(By.id("input-password")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.linkText("Edit your account information")).click();

        Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("value"), "user@localhost.com");
    }

    @Test
    public void successLoginExplicitWaitNoPOM() {
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
    public void successLoginPOMBadApproach() {
        HomePageBadApproach homePageBadApproach = new HomePageBadApproach(driver, wait);

        homePageBadApproach.clickMyAccountDropDown();
        homePageBadApproach.clickBtnLogin();
        homePageBadApproach.fillEmail("user@localhost.com");
        homePageBadApproach.fillPassword("password");
        homePageBadApproach.clickBtnLoginSubmit();
        homePageBadApproach.clickLinkAccountInfo();

        Assert.assertEquals(homePageBadApproach.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void successLoginPOMNoChaining() {
        HomePageNoChaining homePageNoChaining = new HomePageNoChaining(driver, wait);
        homePageNoChaining.clickMyAccountDropDown();
        homePageNoChaining.clickBtnLogin();

        LoginPageNoChaining loginPageNoChaining = new LoginPageNoChaining(driver, wait);
        loginPageNoChaining.fillEmail("sdfadsf");
        loginPageNoChaining.fillPassword("dsfdsdf");
        loginPageNoChaining.clickBtnLoginSubmit();

        AccountPageNoChaining accountPageNoChaining = new AccountPageNoChaining(driver, wait);
        accountPageNoChaining.clickLinkAccountInfo();

        AccountInfoPageNoChaining accountInfoPageNoChaining = new AccountInfoPageNoChaining(driver, wait);

        Assert.assertEquals(accountInfoPageNoChaining.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void successLoginPOMChaining() {
        new HomePageStandard(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin();

        new LoginPageStandard(driver, wait)
                .fillEmail("user@localhost.com")
                .fillPassword("password")
                .clickBtnLoginSubmit();

        new AccountPageStandard(driver, wait)
                .clickLinkAccountInfo();

        AccountInfoPageStandard accountInfoPageStandard = new AccountInfoPageStandard(driver, wait);

        Assert.assertEquals(accountInfoPageStandard.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void successLoginPOM() {
        AccountInfoPageStandard accountInfoPageStandard = new HomePageStandard(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin()
                .fillEmail("user@localhost.com")
                .fillPassword("password")
                .clickBtnLoginSubmit()
                .clickLinkAccountInfo();

        Assert.assertEquals(accountInfoPageStandard.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void failedLoginPOM() {
        String errMsg = new HomePageStandard(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin()
                .fillEmail("user@localhost.com")
                .fillPassword("wrong_password")
                .clickBtnLoginSubmitWithBadCredentials()
                .getBadCredentialsErrorMessage();

        Assert.assertEquals(errMsg, "Warning: No match for E-Mail Address and/or Password.");
    }


    @Test
    public void successLoginPOMExplicitWait() {
        AccountInfoPageExplicit accountInfoPageExplicit = new HomePageExplicit(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin()
                .fillEmail("user@localhost.com")
                .fillPassword("password")
                .clickBtnLoginSubmit()
                .clickLinkAccountInfo();

        Assert.assertEquals(accountInfoPageExplicit.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void successLoginPOMExplicitWaitBasePageMethods() {
        AccountInfoPageBPMethods accountInfoPageBPMethods = new HomePageBPMethods(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin()
                .fillEmail("user@localhost.com")
                .fillPassword("password")
                .clickBtnLoginSubmit()
                .clickLinkAccountInfo();

        Assert.assertEquals(accountInfoPageBPMethods.getEmailFldValue(), "user@localhost.com");
    }

    @Test
    public void successLoginPOMExplicitWaitPageFactory() {
        AccountInfoPageFactory accountInfoPageFactory = new HomePageFactory(driver, wait)
                .clickMyAccountDropDown()
                .clickBtnLogin()
                .fillEmail("user@localhost.com")
                .fillPassword("password")
                .clickBtnLoginSubmit()
                .clickLinkAccountInfo();

        Assert.assertEquals(accountInfoPageFactory.getEmailFldValue(), "user@localhost.com");
    }
}
