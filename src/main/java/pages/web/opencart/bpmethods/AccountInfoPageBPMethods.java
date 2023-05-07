package pages.web.opencart.bpmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.web.BasePage;

public class AccountInfoPageBPMethods extends BasePage {

    private final By fldEmail = By.id("input-email");

    public AccountInfoPageBPMethods(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public String getEmailFldValue() {
        return getElementAttribute(fldEmail, "value");
    }

}
