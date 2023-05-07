package pages.web.opencart.bad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageBadApproach extends BasePage {

    // HOME PAGE
    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");

    // LOGIN PAGE
    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");

    // ACCOUNT PAGE
    private final By linkAccountInfo = By.linkText("Edit your account information");


    public HomePageBadApproach(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickMyAccountDropDown() {
        driver.findElement(myAccountDropDown).click();
    }

    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
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

    public void clickLinkAccountInfo() {
        driver.findElement(linkAccountInfo).click();
    }

    public String getEmailFldValue() {
        return driver.findElement(fldEmail).getAttribute("value");
    }

}
