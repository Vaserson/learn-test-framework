package pages.web.opencart.nochaining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountInfoPageNoChaining extends BasePage {

    private final By fldEmail = By.id("input-email");

    public AccountInfoPageNoChaining(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public String getEmailFldValue() {
        return driver.findElement(fldEmail).getAttribute("value");
    }

}
