package pages.web.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.web.BasePage;

public class HomePage extends BasePage {

    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");

    private final By fldEmail = By.id("input-email");
    private final By fldPassword = By.id("input-password");
    private final By btnLoginSubmit = By.cssSelector("input[value='Login']");

    private final By linkAccountInfo = By.linkText("Edit your account information");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void goTo(String url) {
        driver.get(url);
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
