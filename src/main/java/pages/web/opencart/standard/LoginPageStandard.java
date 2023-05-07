package pages.web.opencart.standard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class LoginPageStandard extends BasePage {

    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");
    private final By msgBadCredentials = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public LoginPageStandard(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public LoginPageStandard fillEmail(String email) {
        driver.findElement(fldEmail).sendKeys(email);
        return this;
    }

    public LoginPageStandard fillPassword(String password) {
        driver.findElement(fldPassword).sendKeys(password);
        return this;
    }

    public AccountPageStandard clickBtnLoginSubmit() {
        driver.findElement(btnLoginSubmit).click();
        return new AccountPageStandard(driver, wait);
    }

    public LoginPageStandard clickBtnLoginSubmitWithBadCredentials() {
        driver.findElement(btnLoginSubmit).click();
        return this;
    }

    public String getBadCredentialsErrorMessage() {
        return driver.findElement(msgBadCredentials).getText();
    }

}
