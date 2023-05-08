package pages.web.opencart.nochaining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class HomePageNoChaining extends BasePage {

    private final By myAccountDropDown = By.xpath("//i[@class='fa fa-user']");
    private final By btnLogin = By.linkText("Login");


    public HomePageNoChaining(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickMyAccountDropDown() {
        driver.findElement(myAccountDropDown).click();
    }

    public void clickBtnLogin() {
        driver.findElement(btnLogin).click();
    }

}
