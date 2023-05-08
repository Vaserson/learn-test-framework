package pages.web.opencart.nochaining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountPageNoChaining extends BasePage {

    private final By linkAccountInfo = By.linkText("Edit your account information");

    public AccountPageNoChaining(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickLinkAccountInfo() {
        driver.findElement(linkAccountInfo).click();
    }

}
