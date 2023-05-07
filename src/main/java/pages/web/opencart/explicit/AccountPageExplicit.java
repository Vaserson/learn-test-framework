package pages.web.opencart.explicit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountPageExplicit extends BasePage {

    private final By linkAccountInfo = By.linkText("Edit your account information");

    public AccountPageExplicit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public AccountInfoPageExplicit clickLinkAccountInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(linkAccountInfo)).click();
        return new AccountInfoPageExplicit(driver, wait);
    }

}
