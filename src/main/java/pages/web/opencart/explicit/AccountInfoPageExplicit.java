package pages.web.opencart.explicit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountInfoPageExplicit extends BasePage {

    private final By fldEmail = By.id("input-email");

    public AccountInfoPageExplicit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public String getEmailFldValue() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(fldEmail)).getAttribute("value");
    }

}
