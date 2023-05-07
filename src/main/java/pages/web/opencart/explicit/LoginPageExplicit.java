package pages.web.opencart.explicit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class LoginPageExplicit extends BasePage {

    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");
    private final By msgBadCredentials = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public LoginPageExplicit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public LoginPageExplicit fillEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(fldEmail)).sendKeys(email);
        return this;
    }

    public LoginPageExplicit fillPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(fldPassword)).sendKeys(password);
        return this;
    }

    public AccountPageExplicit clickBtnLoginSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLoginSubmit)).click();
        return new AccountPageExplicit(driver, wait);
    }

    public LoginPageExplicit clickBtnLoginSubmitWithBadCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLoginSubmit)).click();
        return this;
    }

    public String getBadCredentialsErrorMessage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(msgBadCredentials)).getText();
    }

}
