package pages.web.opencart.explicit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageExplicit extends BasePage {

    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");


    public HomePageExplicit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public HomePageExplicit clickMyAccountDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountDropDown)).click();
        return this;
    }

    public LoginPageExplicit clickBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
        return new LoginPageExplicit(driver, wait);
    }

}
