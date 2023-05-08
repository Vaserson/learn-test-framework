package pages.web.opencart.nochaining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class LoginPageNoChaining extends BasePage {

    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");
    private final By msgBadCredentials = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public LoginPageNoChaining(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void fillEmail(String email) {
        driver.findElement(fldEmail).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(fldPassword).sendKeys(password);
    }

    public void clickBtnLoginSubmit() {
        driver.findElement(btnLoginSubmit).click();
    }

    public void clickBtnLoginSubmitWithBadCredentials() {
        driver.findElement(btnLoginSubmit).click();
    }

    public String getBadCredentialsErrorMessage() {
        return driver.findElement(msgBadCredentials).getText();
    }

}
