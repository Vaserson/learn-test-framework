package pages.web.opencart.standard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageStandard extends BasePage {

    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");


    public HomePageStandard(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public HomePageStandard clickMyAccountDropDown() {
        driver.findElement(myAccountDropDown).click();
        return this;
    }

    public LoginPageStandard clickBtnLogin() {
        driver.findElement(btnLogin).click();
        return new LoginPageStandard(driver, wait);
    }

}
