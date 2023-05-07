package pages.web.opencart.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class LoginPageFactory extends BasePage {

    @FindBy(id = "input-email") WebElement fldEmail;
    @FindBy(id = "input-password") WebElement fldPassword;
    @FindBy(css = "input[value='Login']") WebElement btnLoginSubmit;
    @FindBy(css = ".alert.alert-danger.alert-dismissible") WebElement msgBadCredentials;

/*    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");
    private final By msgBadCredentials = By.cssSelector(".alert.alert-danger.alert-dismissible");*/

    public LoginPageFactory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    public LoginPageFactory fillEmail(String email) {
       fill(fldEmail, email);
        return this;
    }

    public LoginPageFactory fillPassword(String password) {
        fill(fldPassword, password);
        return this;
    }

    public AccountPageFactory clickBtnLoginSubmit() {
        click(btnLoginSubmit);
        return new AccountPageFactory(driver, wait);
    }

    public LoginPageFactory clickBtnLoginSubmitWithBadCredentials() {
        click(btnLoginSubmit);
        return this;
    }

    public String getBadCredentialsErrorMessage() {
        return getPresentElement(msgBadCredentials).getText();
    }

}
