package pages.web.opencart.standard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountPageStandard extends BasePage {

    private final By linkAccountInfo = By.linkText("Edit your account information");

    public AccountPageStandard(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public AccountInfoPageStandard clickLinkAccountInfo() {
        driver.findElement(linkAccountInfo).click();
        return new AccountInfoPageStandard(driver, wait);
    }

}
