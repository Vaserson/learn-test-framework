package pages.web.opencart.bpmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class LoginPageBPMethods extends BasePage {

    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");
    private final By msgBadCredentials = By.cssSelector(".alert.alert-danger.alert-dismissible");

    public LoginPageBPMethods(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public LoginPageBPMethods fillEmail(String email) {
        fill(fldEmail, email);
        return this;
    }

    public LoginPageBPMethods fillPassword(String password) {
        fill(fldPassword, password);
        return this;
    }

    public AccountPageBPMethods clickBtnLoginSubmit() {
        click(btnLoginSubmit);
        return new AccountPageBPMethods(driver, wait);
    }

    public LoginPageBPMethods clickBtnLoginSubmitWithBadCredentials() {
        click(btnLoginSubmit);
        return this;
    }

    public String getBadCredentialsErrorMessage() {
        return getPresentElement(msgBadCredentials).getText();
    }

}
