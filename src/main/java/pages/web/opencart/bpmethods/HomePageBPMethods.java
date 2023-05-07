package pages.web.opencart.bpmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageBPMethods extends BasePage {

    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");


    public HomePageBPMethods(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public HomePageBPMethods clickMyAccountDropDown() {
        click(myAccountDropDown);
        return this;
    }

    public LoginPageBPMethods clickBtnLogin() {
        click(btnLogin);
        return new LoginPageBPMethods(driver, wait);
    }

}
